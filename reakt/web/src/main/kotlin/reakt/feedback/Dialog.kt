package reakt

import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import styled.css
import styled.styledDiv
import theme.ThemeConsumer
import theme.backgroundColor
import theme.onSurfaceColor
import theme.surfaceColor
import kotlinx.extensions.onDesktop
import kotlinx.extensions.onMobile

private class DialogProps(
    val desktopWidth: LinearDimension,
    val mobileWidth: LinearDimension,
    val width: LinearDimension,
    val children: RBuilder.() -> Unit,
    val onExit: () -> Unit
) : Props

private fun RBuilder.card(props: DialogProps) = ThemeConsumer { theme ->
    styledDiv {
        css {
            position = Position.relative
            backgroundColor = theme.surfaceColor
            color = theme.onSurfaceColor
            borderRadius = 8.px
            minHeight = 10.em
            paddingTop = 1.em
            onDesktop {
                width = props.desktopWidth
            }
            onMobile {
                width = props.mobileWidth
            }
        }
        styledDiv {
            css {
                position = Position.absolute
                top = 0.px
                right = 0.px
                padding(0.5.em)
                cursor = Cursor.pointer
                fontSize = 1.5.em
                userSelect = UserSelect.none
            }
            FaTimes {}
            attrs.onClickFunction = { props.onExit() }
        }
        props.children.let { it() }
    }
}

private val Dialog = fc<DialogProps> { props ->
    ThemeConsumer { theme ->
        styledDiv {
            css {
                width = 100.vw
                height = 100.vh
                position = Position.fixed
                left = 0.px
                top = 0.px
                backgroundColor = theme.backgroundColor.withAlpha(0.4)
                display = Display.flex
                justifyContent = JustifyContent.center
                alignItems = Align.center
                zIndex = 99999
            }
            card(props)
        }
    }
}

fun RBuilder.Dialog(
    desktopWidth: LinearDimension = 50.pct,
    mobileWidth: LinearDimension = 90.pct,
    width: LinearDimension = 50.pct,
    onExit: () -> Unit,
    children: RBuilder.() -> Unit
) = child(Dialog, DialogProps(desktopWidth, mobileWidth, width, children, onExit))