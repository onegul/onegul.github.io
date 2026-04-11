package co.gul.model.screen

sealed interface Screen {
    data object Home : Screen
    data object Resume : Screen
    data object Library : Screen
    data object Notebook : Screen
}