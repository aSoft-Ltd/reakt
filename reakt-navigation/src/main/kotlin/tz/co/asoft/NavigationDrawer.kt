package tz.co.asoft

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RBuilder
import react.RProps
import react.RState
import react.setState
import styled.css
import styled.styledDiv
import tz.co.asoft.NavigationDrawer.Props
import tz.co.asoft.NavigationDrawer.State

@JsExport
class NavigationDrawer private constructor(p: Props) : Component<Props, State>(p) {
    class Props(
        val drawer: RBuilder.() -> Unit,
        val content: RBuilder.() -> Unit,
        val drawerState: StateFlow<DrawerState>,
        val portraitWidth: LinearDimension,
        val landscapeWidth: LinearDimension
    ) : RProps

    class State(var drawerState: DrawerState) : RState

    init {
        state = State(p.drawerState.value)
    }

    override fun componentDidMount() {
        launch {
            props.drawerState.collect {
                setState { drawerState = it }
            }
        }
    }

    private fun RBuilder.DrawerLayout() = ThemeConsumer { theme ->
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
                    if (state.drawerState == DrawerState.Closed) {
                        left = -props.landscapeWidth
                    }
                }
                onMobile {
                    width = props.portraitWidth
                    if (state.drawerState == DrawerState.Closed) {
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

    private fun RBuilder.ContentLayout() = ThemeConsumer { theme ->
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
                    if (state.drawerState == DrawerState.Closed) {
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

    override fun RBuilder.render(): dynamic = styledDiv {
        css {
            width = 100.pct
            height = 100.pct
        }
        ContentLayout()
        DrawerLayout()
    }
}

fun RBuilder.NavigationDrawer(
    drawer: RBuilder.() -> Unit,
    content: RBuilder.() -> Unit,
    drawerState: StateFlow<DrawerState>,
    portraitWidth: LinearDimension = 80.pct,
    landscapeWidth: LinearDimension = 20.pct
) = child(
    NavigationDrawer::class.js, Props(
        drawer = drawer,
        content = content,
        drawerState = drawerState,
        portraitWidth = portraitWidth,
        landscapeWidth = landscapeWidth
    )
) {}

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