package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import tz.co.asoft.ThemeConsumer
import tz.co.asoft.justifySelf
import tz.co.asoft.onSurfaceColor
import tz.co.asoft.surfaceColor

/**
 * Renders an AppBar.
 * @param left A lambda to build content on the left section of the AppBar
 * @param middle A lambda to build content on the middle section of the AppBar
 * @param right A lambda to build content on the right side of the AppBar
 * @param bgColor The background color of the AppBar. If no color is set, [ColorPalette.surface] is used
 * @param color The text color to be used on the AppBar. If no color is set, [ColorPalette.onSurface] is used
 */
fun RBuilder.AppBar(
    left: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    middle: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    right: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    bgColor: Color? = null,
    color: Color? = null
) = ThemeConsumer { theme ->
    styledDiv {
        css {
            display = Display.grid
            position = Position.sticky
            top = 0.px
            gridTemplateColumns = GridTemplateColumns("auto auto auto")
            backgroundColor = bgColor ?: theme.surfaceColor
            this.color = color ?: theme.onSurfaceColor
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