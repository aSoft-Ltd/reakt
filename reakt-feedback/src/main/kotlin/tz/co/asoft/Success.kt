package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.TextAlign
import react.RBuilder
import styled.css
import styled.styledDiv

fun RBuilder.Success(msg: String = "Success", handler: (RBuilder.(ReactTheme) -> Unit)? = null) = ThemeConsumer { theme ->
    styledDiv {
        css { +wrapper }

        styledDiv {
            css {
                color = theme.primaryColor
                fontSize = 3.em
            }
            FaCheck {}
        }

        styledDiv {
            css {
                margin(1.em)
                color = theme.onSurfaceColor
            }
            +msg
        }

        styledDiv {
            css {
                width = 100.pct
                textAlign = TextAlign.center
            }
            handler?.let { it(theme) }
        }
    }
}