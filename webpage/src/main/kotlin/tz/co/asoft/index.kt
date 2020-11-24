package tz.co.asoft

import kotlinx.browser.document
import react.dom.render
import react.router.dom.browserRouter

val kfg by lazy { konfig() }

fun main() = render(document.getElementById("root")) {
    browserRouter {
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