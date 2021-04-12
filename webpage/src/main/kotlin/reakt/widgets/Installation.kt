package reakt.widgets

import kotlinx.css.Align
import kotlinx.css.alignItems
import react.RBuilder
import reakt.CodeBlock
import reakt.FaDownload
import reakt.Grid
import styled.css
import styled.styledSpan
import theme.clazz
import applikation.konfig

fun RBuilder.Installation() = Grid { theme ->
    val version: String by konfig()
    Grid("auto 1fr") {
        css { alignItems = Align.center }
        FaDownload{}
        styledSpan {
            css { +theme.text.h2.clazz }
            +"Setup"
        }
    }

    CodeBlock {
        +"""
            repositories {
               mavenCentral()
            }
          
            dependencies {
                // import only what you need
                api("tz.co.asoft:reakt-text:$version"))
                api("tz.co.asoft:reakt-buttons:$version"))
            }
        """.trimIndent()
    }
}