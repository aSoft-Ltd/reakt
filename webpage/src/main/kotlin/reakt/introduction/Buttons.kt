package reakt.introduction

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import react.RBuilder
import reakt.*
import styled.css
import styled.styledHr
import theme.clazz
import kotlinx.extensions.onDesktop

fun RBuilder.Buttons() = Grid(gap = "0em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
        onDesktop { gridRow = GridRow("1/2") }
    }
    Grid {
        css {
            +theme.text.h2.clazz
            padding(0.5.em)
        }
        +"Buttons"
        styledHr {
            css {
                width = 100.pct
                centerSelf()
            }
        }
    }

    Grid(cols = "1fr 1fr 1fr") {
        css { padding(0.5.em) }
        ContainedButton("Contained Button")
        TextButton("Text Button")
        OutlinedButton("Outlined Button")
    }
}