package reakt.widgets

import kotlinx.browser.window
import kotlinx.css.Align
import kotlinx.css.alignItems
import kotlinx.css.em
import react.RBuilder
import reakt.*
import styled.css
import styled.styledSpan
import theme.clazz

fun RBuilder.Output() = Grid { theme ->
    Grid("auto 1fr") {
        css { alignItems = Align.center }
        FaTv {}
        styledSpan {
            css { +theme.text.h2.clazz }
            +"Output"
        }
    }

    Grid(gap = 1.em) {
        css { centerContent() }
        for (i in 1..2) TextInput(name = "name $i", label = "Test Label $i", hint = "John Doe $i")

        Button("Submit") {
            window.alert("Hello from Reakt")
        }
    }
}