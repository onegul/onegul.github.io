package co.gul

import androidx.compose.runtime.*
import co.gul.model.screen.Screen
import co.gul.ui.screen.HomeScreen
import co.gul.ui.screen.LibraryScreen
import co.gul.ui.screen.NotebookScreen
import co.gul.ui.screen.ResumeScreen
import co.gul.ui.component.NavBar
import co.gul.ui.theme.AppStyle
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyle)
        App()
    }
}

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    fun navigate(screen: Screen) {
        currentScreen = screen
        kotlinx.browser.window.scrollTo(0.0, 0.0)
    }

    Div(attrs = { classes(AppStyle.pageWrapper) }) {
        NavBar(current = currentScreen, onNavigate = ::navigate)

        when (currentScreen) {
            Screen.Home -> HomeScreen(onNavigate = ::navigate)
            Screen.Resume -> ResumeScreen(onNavigate = ::navigate)
            Screen.Library -> LibraryScreen(onNavigate = ::navigate)
            Screen.Notebook -> NotebookScreen(onNavigate = ::navigate)
        }
    }
}
