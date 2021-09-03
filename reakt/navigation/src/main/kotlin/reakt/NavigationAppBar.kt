package reakt

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.html.DIV
import kotlinx.html.js.onClickFunction
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import theme.ReactTheme
import theme.ThemeConsumer

/**
 * Renders an NavigationAppBar.
 * Built on top of [AppBar]
 * @param left A lambda to build content on the left section of the AppBar
 * @param middle A lambda to build content on the middle section of the AppBar
 * @param right A lambda to build content on the right side of the AppBar
 * @param bgColor The background color of the AppBar. If no color is set, [ColorPalette.surface] is used
 * @param color The text color to be used on the AppBar. If no color is set, [ColorPalette.onSurface] is used
 */
fun RBuilder.NavigationAppBar(
    drawerController: MutableStateFlow<DrawerState>,
    left: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    middle: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    right: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    bgColor: Color? = null,
    color: Color? = null
) = AppBar(
    left = {
        css {
            display = Display.flex
            children { marginLeft = 0.5.rem }
            firstChild { marginLeft = 0.rem }
        }
        styledDiv {
            css {
                fontSize = 1.2.rem
                cursor = Cursor.pointer
            }
            attrs.onClickFunction = { drawerController.value = DrawerState.Opened }
            FaBars {}
        }


        ThemeConsumer { theme ->
            styledDiv {
                left?.invoke(this, theme)
            }
        }
    },
    middle = middle,
    right = right,
    bgColor = bgColor,
    color = color
)