package reakt.navigation

import reakt.FaBars
import reakt.NavMenu
import reakt.WebPage


private const val navigationLink = "/navigation"
private const val navigationDrawerLink = "/navigation/drawer"

val NavigationPages = listOf(
    WebPage(navigationLink) { NavigationIntro() },
    WebPage(navigationDrawerLink) { NavigationDrawer() }
)

val NavigationMenus = listOf(
    NavMenu("Navigation Intro", navigationLink, FaBars, "*"),
    NavMenu("Navigation Drawer", navigationDrawerLink, FaBars, "*")
)