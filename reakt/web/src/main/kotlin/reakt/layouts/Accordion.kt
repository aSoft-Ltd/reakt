@file:Suppress("PackageDirectoryMismatch")

package reakt

import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transform
import kotlinx.css.properties.transition
import kotlinx.css.properties.translateY
import kotlinx.extensions.UIID
import kotlinx.html.DIV
import kotlinx.html.classes
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLDivElement
import react.*
import react.dom.attrs
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import theme.ReactTheme
import theme.ThemeConsumer

private class AccordionProps(
    val header: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit,
    val content: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit
) : Props

private val DEFAULT_HEIGHT = 0.em

private val Accordion = fc<AccordionProps> { props ->
    val header = props.header
    val body = props.content

    val titleRef = useRef<HTMLDivElement>()
    val contentRef = useRef<HTMLDivElement>()
    var accordionHeight by useState(DEFAULT_HEIGHT)

    useLayoutEffectOnce {
        accordionHeight = contentRef.current?.offsetHeight?.px ?: DEFAULT_HEIGHT
    }

    styledDiv {
        css {
            position = Position.relative
            padding(0.5.em)
            child(".title.opened") {
                before {
                    this.content = QuotedString("-")
                }
            }
            child(".content.opened") {
                height = accordionHeight
            }
        }
        ThemeConsumer { theme ->
            styledDiv {
                css {
                    position = Position.relative
                    cursor = Cursor.pointer
                    before {
                        this.content = QuotedString("+")
                        position = Position.absolute
                        top = 50.pct
                        right = 0.em
                        transform { translateY((-50).pct) }
                        fontSize = 1.5.em
                    }
                }
                attrs {
                    ref = titleRef
                    classes = setOf("title", "closed")
                    onClickFunction = {
                        titleRef.current?.classList?.toggle("opened")
                        contentRef.current?.classList?.toggle("opened")
                    }
                }
                header(theme)
            }

            styledDiv {
                css {
                    position = Position.relative
                    overflow = Overflow.hidden
                    transition(duration = 0.5.s)
                    height = if (accordionHeight == DEFAULT_HEIGHT) LinearDimension.auto else DEFAULT_HEIGHT
                }
                attrs {
                    ref = contentRef
                    classes = setOf("content")
                }
                body(theme)
            }
        }
    }
}

fun RBuilder.Accordion(
    header: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit,
    body: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit
) = child(Accordion, AccordionProps(header, body)) {}

fun RBuilder.Accordion(
    title: String,
    body: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit
) = Accordion({ +title }, body)

