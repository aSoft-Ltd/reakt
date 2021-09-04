package reakt

import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.html.DIV
import kotlinx.html.js.onClickFunction
import react.*
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import theme.ThemeConsumer
import theme.onSurfaceColor
import theme.surfaceColor

private class TabsProps(
    val lineSize: LinearDimension,
    val beforeTabs: (StyledDOMBuilder<DIV>.() -> Unit)?,
    val tabs: List<Tab>
) : Props

private val Tabs = fc<TabsProps> { props ->
    var currentTab by useState(
        props.tabs.firstOrNull() ?: throw Exception("Tabs Component: Must have at least one tab"),
    )
    var tabs by useState(props.tabs)
    Grid(rows = "auto 1fr", gap = 0.px) { theme ->
        FlexBox {
            css {
                borderBottom = "solid ${props.lineSize} ${theme.onSurfaceColor}"
                children {
                    backgroundColor = theme.surfaceColor
                    color = theme.onSurfaceColor
                    position = Position.relative
                    userSelect = UserSelect.none
                    zIndex = 1
                    margin(horizontal = 0.1.em)
                    padding(horizontal = 0.3.em)
                    paddingTop = 0.3.em
                    paddingBottom = (-0.3).em
                    boxShadow(
                        offsetY = -props.lineSize,
                        color = theme.onSurfaceColor.withAlpha(0.2),
                        blurRadius = 2.px,
                        spreadRadius = (-1).px
                    )
                }
            }
            props.beforeTabs?.let { it() }
            for (tab in tabs) TabHeader(
                tab = tab,
                currentTab = currentTab,
                tabs = tabs,
                props = props,
                onTabClosed = {
                    if (tabs.size > 1) {
                        tabs = tabs - it
                        currentTab = tabs.first()
                    }
                },
                onTabSelected = { currentTab = it }
            )
        }
        Grid {
            css {
                backgroundColor = theme.surfaceColor
                color = theme.onSurfaceColor
                paddingTop = 0.5.em
            }
            currentTab.content.let { it(theme) }
        }
    }
}

private fun RBuilder.TabHeader(
    tab: Tab,
    currentTab: Tab,
    tabs: List<Tab>,
    props: TabsProps,
    onTabClosed: (Tab) -> Unit,
    onTabSelected: (Tab) -> Unit
) = ThemeConsumer { theme ->
    styledDiv {
        attrs.onClickFunction = { onTabSelected(tab) }
        css {
            cursor = Cursor.pointer
            if (tab == tabs.firstOrNull() && props.beforeTabs == null) marginLeft = 0.em
            if (tab == tabs.lastOrNull()) marginRight = 0.em
            borderTopLeftRadius = 5.px
            borderTopRightRadius = 5.px
            transition(duration = 0.2.s)
            if (tab == currentTab) {
                boxShadow(offsetY = props.lineSize, color = theme.surfaceColor)
                borderLeft = "solid ${props.lineSize} ${theme.onSurfaceColor}"
                borderTop = "solid ${props.lineSize} ${theme.onSurfaceColor}"
                borderRight = "solid ${props.lineSize} ${theme.onSurfaceColor}"
                after {
                    position = Position.absolute
                    left = -props.lineSize
                    right = props.lineSize
                    bottom = -props.lineSize
                    width = 100.pct + props.lineSize + props.lineSize
                    height = 100.pct
                    borderLeft = "solid ${props.lineSize} ${theme.onSurfaceColor}"
                    borderRight = "solid ${props.lineSize} ${theme.onSurfaceColor}"
                }
            } else {
                borderLeft = "solid ${props.lineSize} ${theme.surfaceColor}"
                borderTop = "solid ${props.lineSize} ${theme.surfaceColor}"
                borderRight = "solid ${props.lineSize} ${theme.surfaceColor}"
            }
        }

        Grid(cols = "auto" + if (tab.isCloseable) " auto" else "") {
            if (tab.icon != null) {
                Grid(cols = "auto auto", gap = 0.2.em) {
                    styledDiv { (tab.icon) {} }
                    styledDiv { +tab.name }
                }
            } else {
                styledDiv { +tab.name }
            }
            if (tab.isCloseable) styledDiv {
                attrs.onClickFunction = {
                    onTabClosed(tab)
                }
                FaTimes {}
            }
        }
    }
}

fun RBuilder.Tabs(
    vararg tabs: Tab
) = child(Tabs, TabsProps(1.px, null, tabs.toList())) {}

fun RBuilder.Tabs(
    lineSize: LinearDimension = 1.px,
    beforeTabs: (StyledDOMBuilder<DIV>.() -> Unit)? = null,
    tabs: List<Tab>
) = child(Tabs, TabsProps(lineSize, beforeTabs, tabs)) {}