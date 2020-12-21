@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import react.RProps
import tz.co.asoft.navigation.NavigationIntro


private const val navigationLink ="/navigation"
private const val navigationDrawerLink = "/navigation/drawer"

val NavigationPages = listOf<WebPage<RProps>>(
    WebPage(navigationLink) { NavigationIntro() },
    WebPage(navigationDrawerLink) { NavigationDrawer() }
)

val NavigationMenus = listOf(
    NavMenu("Navigation Intro", navigationLink, FaBars, "*"),
    NavMenu("Navigation Drawer", navigationDrawerLink, FaBars, "*")
)