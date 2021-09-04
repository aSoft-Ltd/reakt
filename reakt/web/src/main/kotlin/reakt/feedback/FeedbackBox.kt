package reakt

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadow
import kotlinx.extensions.onDesktop
import kotlinx.extensions.onMobile
import kotlinx.html.DIV
import react.*
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

private class FeedbackBoxProps(
    val title: String,
    val primaryColor: Color,
    val surfaceColor: Color,
    val onSurfaceColor: Color,
    val shadowColor: Color,
    val actions: List<AButton<Unit>>,
    val icon: ElementType<IconProps>,
    val children: StyledDOMBuilder<DIV>.() -> Unit
) : Props

private fun RBuilder.Container(content: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        onMobile { margin(horizontal = 0.5.em) }
        onDesktop { margin(horizontal = 30.pct) }
    }
    AspectRationDiv { content() }
}

private val FeedbackBox = fc<FeedbackBoxProps> { props ->
    Container {
        styledDiv {
            css {
                backgroundColor = props.surfaceColor
                borderRadius = 4.px
                color = props.onSurfaceColor
                padding(1.em)
                boxShadow(props.shadowColor.withAlpha(0.1), blurRadius = 2.px, spreadRadius = 1.px)
            }
            styledDiv {
                css {
                    centerContent()
                    marginBottom = 0.5.em
                    fontSize = 2.em
                }
                props.icon {}
            }

            styledDiv {
                css {
                    centerContent()
                    marginBottom = 0.5.em
                }
                +props.title
            }

            if (props.children != undefined) styledDiv {
                css { marginBottom = 1.em }
                props.children.let { it() }
            }

            if (props.actions.isNotEmpty()) Grid(cols = props.actions.joinToString(separator = " ") { "1fr" }) {
                for (action in props.actions) Button(action, Unit)
            }
        }
    }
}

fun RBuilder.FeedbackBox(
    title: String,
    primaryColor: Color,
    surfaceColor: Color,
    onSurfaceColor: Color,
    shadowColor: Color,
    icon: ElementType<IconProps>,
    actions: List<AButton<Unit>>,
    children: StyledDOMBuilder<DIV>.() -> Unit
) = child(
    FeedbackBox,
    FeedbackBoxProps(title, primaryColor, surfaceColor, onSurfaceColor, shadowColor, actions, icon, children)
)