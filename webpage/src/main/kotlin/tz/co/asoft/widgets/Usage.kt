@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import kotlinx.css.Align
import kotlinx.css.alignItems
import react.RBuilder
import styled.css
import styled.styledSpan

fun RBuilder.Usage() = Grid { theme ->
    Grid("auto 1fr") {
        css { alignItems = Align.center }
        FaTools {}
        styledSpan {
            css { +theme.text.h2.clazz }
            +"Usage"
        }
    }

    CodeBlock {
        +"""
        Grid(cols = "1fr auto", gap = 1.em) {
            for(i in 1..2) TextInput(
                label = "Test Label ${'$'}i",
                hint = "John Doe ${'$'}i"
            )
            Button("Submit") {
                window.alert("Hello from Reakt")
            }
        }
        """.trimIndent()
    }
}