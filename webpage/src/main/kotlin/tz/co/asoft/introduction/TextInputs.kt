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

fun RBuilder.TextInputs() = Grid(gap = "1em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
        onDesktop {
            gridRow = GridRow("1/3")
        }
    }

    styledDiv {
        css { +theme.text.h2.clazz }
        +"TextInputs"
        styledHr {
            css {
                width = 100.pct
                centerSelf()
            }
        }
    }

    SearchInput(hint = "Search here . . .", css = { width = 100.pct }) {
        console.log("Searched $it")
    }

    TextInput(
        name = "Text Input",
        label = "Label Example",
        hint = "Hint example"
    )

    TextInput(
        name = "Email Input",
        label = "Email label example",
        hint = "john@doe.com",
        type = InputType.email
    )

    TextInput(
        name = "Phone Input",
        label = "Phone label example",
        hint = "+255752748674",
        type = InputType.tel
    )

    TextInput(
        name = "Password Input",
        label = "Password label example",
        hint = "secret-password",
        type = InputType.password
    )
}