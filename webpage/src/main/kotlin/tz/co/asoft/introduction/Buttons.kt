package tz.co.asoft.introduction

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadow
import react.RBuilder
import styled.css
import styled.styledDiv
import styled.styledHr
import tz.co.asoft.*

fun RBuilder.Buttons() = Grid(gap = "0em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
    }
    Grid {
        css {
            +theme.text.h2.clazz
            padding(0.5.em)
        }
        +"Buttons"
    }
    styledHr {
        css {
            width = 100.pct
            centerSelf()
        }
    }
    Grid(cols = "1fr 1fr 1fr") {
        css { padding(0.5.em) }
        ContainedButton("Contained Button")
        TextButton("Text Button")
        OutlinedButton("Outlined Button")
    }
}