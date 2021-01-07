package tz.co.asoft

import kotlinx.browser.document
import react.dom.render
import react.router.dom.browserRouter
import styled.styledDiv

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
                pages = listOf(Home, Introduction) + FeedbackPages + NavigationPages
            )
        }
    }
}