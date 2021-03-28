package reakt.introduction

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadow
import react.RBuilder
import reakt.*
import styled.css
import styled.styledDiv
import styled.styledHr
import theme.clazz
import tz.co.asoft.onDesktop

fun RBuilder.Media() = Grid(gap = "1em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
        onDesktop {
            gridRow = GridRow("5/6")
            gridColumn = GridColumn("2/3")
        }
    }

    styledDiv {
        css { +theme.text.h2.clazz }
        +"Media"
        styledHr {
            css {
                width = 100.pct
                centerSelf()
            }
        }
    }

    Grid(cols = "1fr 2fr 1fr 1fr") {
        Audio(src = "")

        VideoPlayer(src = "")

        ImageUploader()

        ProfilePic("T")
    }
}