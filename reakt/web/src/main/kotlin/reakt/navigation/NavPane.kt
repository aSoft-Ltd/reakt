package reakt

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.extensions.isMobile
import kotlinx.extensions.justifySelf
import kotlinx.html.DIV
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.Props
import react.RBuilder
import react.fc
import react.router.dom.NavLink
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import theme.*

class NavPaneProps(
    val drawerController: MutableStateFlow<DrawerState>,
    val header: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit,
    val moduleGroups: Map<String, List<NavMenu>>
) : Props

private fun RBuilder.group(handler: StyledDOMBuilder<DIV>.() -> Unit) = Grid { theme ->
    css {
        position = Position.relative
        paddingBottom = 1.em
        borderBottom = "solid 1px ${theme.onBackgroundVariantColor}"
        child("div") {
            justifySelf = JustifyContent.center
        }
    }
    handler()
}

private fun RBuilder.header(props: NavPaneProps) = ThemeConsumer { theme ->
    group {
        props.apply { header(theme) }
        styledDiv {
            css {
                position = Position.absolute
                top = 0.px
                right = 0.px
                fontSize = 1.3.em
                marginRight = 0.2.em
                marginTop = 0.2.em
                cursor = Cursor.pointer
                zIndex = 5
            }
            attrs.onClickFunction = { props.drawerController.value = DrawerState.Closed }
            FaTimes {}
        }
    }
}

private fun RBuilder.menu(props: NavPaneProps, navMenu: NavMenu) = ThemeConsumer { theme ->
    NavLink {
        attrs {
            to = navMenu.link
            exact = true
            strict = true
        }
        styledDiv {
            css {
                width = 100.pct
                display = Display.grid
                padding(vertical = 0.3.em, horizontal = 1.em)
                gap = 1.em
                gridTemplateColumns = GridTemplateColumns("1fr 9fr")
                transition(duration = 0.2.s)
                cursor = Cursor.pointer
                div {
                    display = Display.flex
                    alignItems = Align.center
                    justifyContent = JustifyContent.flexStart
                }
                hover {
                    backgroundColor = theme.primaryColor
                    color = theme.onPrimaryColor
                    child(".icon") {
                        color = theme.onPrimaryColor
                    }
                }
            }

            attrs.onClickFunction = { if (isMobile) props.drawerController.value = DrawerState.Closed }

            styledDiv {
                attrs.classes = setOf("icon")
                css {
                    justifySelf = JustifyContent.center
                }
                navMenu.icon {}
            }

            styledDiv {
                css {
                    justifySelf = JustifyContent.start
                }
                +navMenu.name
            }
        }
    }
}

private val NavPane = fc<NavPaneProps> { props ->
    ThemeConsumer { theme ->
        Scroller {
            style {
                width = 100.pct
                height = 100.vh
                borderRight = "solid 1px ${theme.onBackgroundVariantColor}"
                backgroundColor = theme.backgroundVariantColor
            }
            header(props)
            props.moduleGroups.entries.forEach {
                group {
                    css {
                        width = 100.pct
                        display = Display.grid
                        gridTemplateColumns = GridTemplateColumns("1fr")
                        paddingTop = 1.em
                        gap = 0.em
                        child(".active") {
                            backgroundColor = theme.primaryColor
                            color = theme.onPrimaryColor
                        }
                    }
                    it.value.forEach { menu(props, it) }
                }
            }
        }
    }
}

fun RBuilder.NavPane(
    drawerController: MutableStateFlow<DrawerState>,
    moduleGroups: Map<String, List<NavMenu>>,
    header: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit
) = child(NavPane, NavPaneProps(drawerController, header, moduleGroups))