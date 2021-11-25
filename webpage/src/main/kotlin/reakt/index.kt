package reakt

import applikation.konfig
import kotlinx.browser.document
import react.router.dom.BrowserRouter
import reakt.feedback.FeedbackMenus
import reakt.feedback.FeedbackPages
import reakt.introduction.Introduction
import reakt.navigation.NavigationMenus
import reakt.navigation.NavigationPages
import theme.DarkGrayTheme
import theme.ThemeProvider
import theme.currentTheme

val kfg by lazy { konfig() }

fun main() = document.getElementById("root").setContent {
    currentTheme.value = DarkGrayTheme()
    BrowserRouter {
//        ThemeProvider {
//            ReaktWebpage(
//                moduleGroups = mapOf(
//                    "Intro" to listOf(
//                        NavMenu("Introduction", "/reakt", FaDownload, "*")
//                    ),
//                    "Feedback" to FeedbackMenus,
//                    "Navigation" to NavigationMenus
//                ),
//                pages = listOf(Home, Introduction) + FeedbackPages + NavigationPages
//            )
//        }
    }
}