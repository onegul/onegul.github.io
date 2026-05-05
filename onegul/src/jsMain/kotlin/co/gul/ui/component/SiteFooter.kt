package co.gul.ui.component

import androidx.compose.runtime.Composable
import co.gul.ui.theme.AppStyle
import co.gul.ui.theme.Font
import co.gul.ui.theme.Palette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun SiteFooter() {
    Footer(attrs = {
        style {
            property("border-top", "1px solid ${Palette.outlineVariant}")
        }
    }) {
        Div(attrs = { classes(AppStyle.footer) }) {
            Span(attrs = { classes(AppStyle.footerText) }) {
                Text("© 2026 Gulshan · onegul.github.io")
            }
            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    gap(16.px)
                }
            }) {
                FooterLink("GitHub", "https://github.com/onegul")
                FooterLink("LinkedIn", "https://www.linkedin.com/in/onegul")
                FooterLink("Email", "mailto:gulshan.gkay@gmail.com")
            }
        }
    }
}

@Composable
private fun FooterLink(label: String, href: String) {
    A(href = href, attrs = {
        attr("target", "_blank")
        attr("rel", "noopener noreferrer")
        style {
            fontFamily(Font.MONO)
            fontSize(12.px)
            color(Palette.primary)
            property("letter-spacing", "0.04em")
            property("text-decoration", "none")
        }
    }) { Text(label) }
}