package tz.co.asoft

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.css.*
import kotlinx.html.DIV
import kotlinx.html.js.onClickFunction
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

fun RBuilder.NavigationAppBar(
    drawerController: MutableStateFlow<DrawerState>,
    left: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    middle: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null,
    right: (StyledDOMBuilder<DIV>.(ReactTheme) -> Unit)? = null
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
    right = right
)