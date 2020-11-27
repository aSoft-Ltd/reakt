@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadow
import kotlinx.html.InputType
import react.RBuilder
import styled.css
import styled.styledDiv
import styled.styledHr
import tz.co.asoft.*

fun RBuilder.OtherInputs() = Grid(gap = "1em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
        onDesktop {
            gridRow = GridRow("5/6")
            gridColumn = GridColumn("1/2")
        }
    }

    styledDiv {
        css { +theme.text.h2.clazz }
        +"OtherInputs"
        styledHr {
            css {
                width = 100.pct
                centerSelf()
            }
        }
    }

    DateTimeInput("Date")
    FileInput("file")
    Switch("switch", "test")
    DropDown(name = "dropdown", options = (1..10).map { "Option $it" })
}