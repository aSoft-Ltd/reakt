package reakt

import kotlinx.css.*
import kotlinx.css.TextAlign
import react.RBuilder
import styled.css
import styled.styledDiv
import tz.co.asoft.ReactTheme
import tz.co.asoft.ThemeConsumer
import tz.co.asoft.errorColor

@Deprecated("Use ErrorBox")
fun RBuilder.Error(msg: String, handler: (RBuilder.(ReactTheme) -> Unit)? = null) = ThemeConsumer { theme ->
    styledDiv {
        css { +wrapper }

        styledDiv {
            css {
                color = theme.errorColor
                fontSize = 3.em
            }
            FaRegWindowClose{}
        }

        styledDiv {
            css {
                margin(1.em)
                color = theme.errorColor
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