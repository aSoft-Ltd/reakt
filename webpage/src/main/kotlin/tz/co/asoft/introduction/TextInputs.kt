package tz.co.asoft.introduction

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadow
import kotlinx.html.InputType
import react.RBuilder
import styled.css
import styled.styledDiv
import styled.styledHr
import tz.co.asoft.*

fun RBuilder.TextInputs() = Grid(gap = "0em") { theme ->
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
        +"TextInputs"
    }
    styledHr {
        css {
            width = 100.pct
            centerSelf()
        }
    }
    Grid(cols = "1fr") {
        css { padding(0.5.em) }
        TextInput(
            name = "Text Input",
            label = "Label Example",
            hint = "Hint example"
        )
//
//        TextInput(
//            name = "Email Input",
//            label = "Email label example",
//            hint = "john@doe.com",
//            type = InputType.email
//        )
//
//        TextInput(
//            name = "Phone Input",
//            label = "Phone label example",
//            hint = "+255752748674",
//            type = InputType.tel
//        )
    }
}