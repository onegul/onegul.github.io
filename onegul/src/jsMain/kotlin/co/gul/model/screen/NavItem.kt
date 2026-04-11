package co.gul.model.screen

data class NavItem(
    val screen: Screen,
    val label: String,
    val icon: String,
    val shortLabel: String
)

val NAV_ITEMS = listOf(
    NavItem(Screen.Home, "Home", "○", "Home"),
    NavItem(Screen.Resume, "Resume", "◈", "Resume"),
    NavItem(Screen.Library, "Library", "◎", "Library"),
    NavItem(Screen.Notebook, "Notebook", "◇", "Notebook")
)