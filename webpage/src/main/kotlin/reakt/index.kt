package reakt

import kotlinx.browser.document
import react.router.dom.browserRouter
import reakt.feedback.FeedbackMenus
import reakt.feedback.FeedbackPages
import reakt.navigation.NavigationMenus
import reakt.navigation.NavigationPages
import tz.co.asoft.*

val kfg by lazy { konfig() }

fun main() = document.getElementById("root").setContent {
    currentTheme.value = DarkGrayTheme()
    browserRouter {
        ThemeProvider {
            ReaktWebpage(
                moduleGroups = mapOf(
                    "Intro" to listOf(
                        NavMenu("Introduction", "/", FaDownload, "*")
                    ),
                    "Feedback" to FeedbackMenus,
                    "Navigation" to NavigationMenus
                ),
                pages = listOf(Home, reakt.introduction.Introduction) + FeedbackPages + NavigationPages
            )
        }
    }
}