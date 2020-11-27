package tz.co.asoft

import kotlinx.browser.document
import react.dom.render
import react.router.dom.browserRouter
import styled.styledDiv

val kfg by lazy { konfig() }

fun main() = render(document.getElementById("root")) {
    browserRouter {
        ThemeProvider {
            ReaktWebpage(
                moduleGroups = mapOf(
                    "Intro" to listOf(
                        NavMenu("Introduction", "/", FaDownload, { true })
                    ),
                    "Navigation" to NavigationMenus
                ),
                pages = listOf(Introduction) + NavigationPages
            )
        }
    }
}