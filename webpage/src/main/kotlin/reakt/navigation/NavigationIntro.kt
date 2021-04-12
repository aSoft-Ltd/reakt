package reakt.navigation

import kotlinx.css.em
import kotlinx.css.padding
import react.RBuilder
import react.router.dom.routeLink
import reakt.*
import styled.css
import theme.clazz

fun RBuilder.NavigationIntro() = Grid {
    Surface(margin = 0.5.em) { theme ->

        css { padding(2.em) }
        FlexBox {
            css {
                +theme.text.h2.clazz
                centerContent()
            }
            +"Navigation Components"
        }

        FlexBox {
            css { centerContent() }
            +"Reakt Provides out of the box components to help with navigation"
        }
    }

    Surface(margin = 0.5.em) { theme ->
        FlexBox {
            css {
                +theme.text.h2.clazz
                centerContent()
            }
            +"Setup:Gradle"
        }

        val version: String by kfg
        CodeBlock {
            +"""
            dependencies {
                implementation("tz.co.asoft:reakt-navigation:$version")
            }
        """.trimIndent()
        }
    }

    Surface(margin = 0.5.em) {
        routeLink("/navigation/drawer") {
            Button("Proceed")
        }
    }
}