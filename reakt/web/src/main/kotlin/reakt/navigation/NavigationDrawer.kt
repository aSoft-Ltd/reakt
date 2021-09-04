package reakt

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.extensions.onDesktop
import kotlinx.extensions.onMobile
import kotlinx.extensions.onPaper
import react.*
import styled.css
import styled.styledDiv
import theme.*

private class NavigationDrawerProps(
    val drawer: RBuilder.() -> Unit,
    val content: RBuilder.() -> Unit,
    val drawerState: StateFlow<DrawerState>,
    val portraitWidth: LinearDimension,
    val landscapeWidth: LinearDimension
) : Props

private class NavigationDrawerState(var drawerState: DrawerState) : State

private fun RBuilder.DrawerLayout(
    props: NavigationDrawerProps,
    drawerState: DrawerState
) = ThemeConsumer { theme ->
    styledDiv {
        css {
            width = props.portraitWidth
            backgroundColor = theme.backgroundVariantColor
            color = theme.onBackgroundVariantColor
            position = Position.fixed
            height = 100.pct
            top = 0.px
            left = 0.px
            transition(duration = 0.2.s)
            onDesktop {
                width = props.landscapeWidth
                if (drawerState == DrawerState.Closed) {
                    left = -props.landscapeWidth
                }
            }
            onMobile {
                width = props.portraitWidth
                if (drawerState == DrawerState.Closed) {
                    left = -props.portraitWidth
                }
            }
            onPaper {
                display = Display.none
            }
        }
        Scroller {
            props.drawer(this)
        }
    }
}

private fun RBuilder.ContentLayout(
    props: NavigationDrawerProps,
    drawerState: DrawerState
) = ThemeConsumer { theme ->
    styledDiv {
        css {
            backgroundColor = theme.backgroundColor
            color = theme.onBackgroundColor
            position = Position.fixed
            height = 100.pct
            right = 0.px
            top = 0.px
            transition(duration = 0.2.s)
            onPaper {
                width = 100.pct
            }
            onDesktop {
                width = 100.pct - props.landscapeWidth
                if (drawerState == DrawerState.Closed) {
                    width = 100.pct
                }
            }
            onMobile {
                width = 100.pct
            }
        }
        Scroller {
            props.content(this)
        }
    }
}

private val NavigationDrawer = fc<NavigationDrawerProps> { props ->
    val drawerState = props.drawerState.asState()
    styledDiv {
        css {
            width = 100.pct
            height = 100.pct
        }
        ContentLayout(props, drawerState)
        DrawerLayout(props, drawerState)
    }
}

fun RBuilder.NavigationDrawer(
    drawer: RBuilder.() -> Unit,
    content: RBuilder.() -> Unit,
    drawerState: StateFlow<DrawerState>,
    portraitWidth: LinearDimension = 80.pct,
    landscapeWidth: LinearDimension = 20.pct
) = child(
    NavigationDrawer, NavigationDrawerProps(
        drawer = drawer,
        content = content,
        drawerState = drawerState,
        portraitWidth = portraitWidth,
        landscapeWidth = landscapeWidth
    )
)

fun RBuilder.NavigationDrawer(
    drawer: RBuilder.() -> Unit,
    content: RBuilder.() -> Unit,
    drawerState: DrawerState,
    portraitWidth: LinearDimension = 80.pct,
    landscapeWidth: LinearDimension = 20.pct
) = NavigationDrawer(
    drawer = drawer,
    content = content,
    drawerState = MutableStateFlow(drawerState),
    portraitWidth = portraitWidth,
    landscapeWidth = landscapeWidth
)