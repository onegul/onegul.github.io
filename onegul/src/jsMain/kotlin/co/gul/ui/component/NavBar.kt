package co.gul.ui.component

import androidx.compose.runtime.Composable
import co.gul.model.screen.NAV_ITEMS
import co.gul.model.screen.Screen
import co.gul.ui.theme.AppStyle
import org.jetbrains.compose.web.dom.*

@Composable
fun NavBar(current: Screen, onNavigate: (Screen) -> Unit) {
    Nav(attrs = {
        classes(AppStyle.navBar)
        attr("role", "navigation")
        attr("aria-label", "Main navigation")
    }) {
        Span(attrs = {
            classes(AppStyle.navLogo)
            onClick { onNavigate(Screen.Home) }
            attr("role", "link")
            attr("tabindex", "0")
        }) { Text("Gulshan Kumar") }

        Ul(attrs = { classes(AppStyle.navLinks) }) {
            NAV_ITEMS.forEach { item ->
                Li {
                    Button(attrs = {
                        if (current == item.screen)
                            classes(AppStyle.navLink, AppStyle.navLinkActive)
                        else
                            classes(AppStyle.navLink)
                        onClick { onNavigate(item.screen) }
                        attr("aria-current", if (current == item.screen) "page" else "false")
                    }) { Text(item.label) }
                }
            }
        }
    }
}