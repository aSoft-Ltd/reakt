package tz.co.asoft.widgets

import kotlinx.css.Align
import kotlinx.css.alignItems
import react.RBuilder
import styled.css
import styled.styledSpan
import tz.co.asoft.*

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