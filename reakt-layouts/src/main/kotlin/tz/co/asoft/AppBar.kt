package tz.co.asoft

import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import tz.co.asoft.ThemeConsumer
import tz.co.asoft.justifySelf
import tz.co.asoft.onSurfaceColor
import tz.co.asoft.surfaceColor

fun RBuilder.AppBar(
    left: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    middle: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    right: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null
) = ThemeConsumer { theme ->
    styledDiv {
        css {
            display = Display.grid
            position = Position.sticky
            top = 0.px
            gridTemplateColumns = GridTemplateColumns("auto auto auto")
            backgroundColor = theme.surfaceColor
            color = theme.onSurfaceColor
            padding(1.em)
            zIndex = 10
        }

        styledDiv {
            css {
                alignSelf = Align.center
                justifySelf = JustifyContent.start
            }
            left?.invoke(this, theme)
        }

        styledDiv {
            css {
                justifySelf = JustifyContent.center
            }
            middle?.invoke(this, theme)
        }

        styledDiv {
            css {
                alignSelf = Align.center
                justifySelf = JustifyContent.right
            }
            right?.invoke(this, theme)
        }
    }
}