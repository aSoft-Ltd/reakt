package tz.co.asoft

import kotlinx.css.*
import react.RBuilder
import styled.css
import styled.styledDiv
import tz.co.asoft.*

fun RBuilder.Loader(text: String) = ThemeConsumer { theme ->
    styledDiv {
        css { +wrapper }

        styledDiv {
            css { color = theme.primaryColor }
            LoadingSvg()
        }

        styledDiv {
            css {
                margin(1.em)
                color = theme.onSurfaceColor
            }
            +text
        }
    }
}