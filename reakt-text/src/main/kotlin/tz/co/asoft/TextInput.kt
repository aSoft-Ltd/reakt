package tz.co.asoft

import kotlinx.browser.document
import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.TextAlign
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onBlurFunction
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onFocusFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.defaultValue
import react.dom.pre
import styled.StyleSheet
import styled.css
import styled.styledDiv
import styled.styledInput
import tz.co.asoft.FlatTextInput.Props
import tz.co.asoft.FlatTextInput.State

@JsExport
class FlatTextInput private constructor(p: Props) : RComponent<Props, State>(p) {
    class Props(
        val name: String,
        val label: String,
        val hint: String,
        val value: String?,
        val type: InputType,
        val icon: RClass<IconProps>?,
        val isRequired: Boolean,
        val data: Map<String, Any>?
    ) : RProps

    class State(var textValue: String, var isFocused: Boolean) : RState

    companion object : StyleSheet("text-input-styles") {
        val root by css {
            display = Display.inlineBlock
            position = Position.relative
            backgroundColor = Color.transparent
            width = 100.pct
            border = "none"
            marginTop = 1.em
            marginBottom = 1.em

            before {
                transition(duration = .2.s)
                position = Position.absolute
                height = 1.px
                left = 5.pct
                bottom = 0.px
                backgroundColor = Color.black
            }

            hover {
                before {
                    left = 0.pct
                    height = 2.px
                }
            }

            focus {
                left = 0.pct
                height = 2.px
            }
        }

        val input by css {
            transition(duration = .2.s)
            position = Position.relative
            backgroundColor = Color.transparent
            minHeight = 1.5.em
            width = 100.pct
            minWidth = 10.em
            border = "none"
            textAlign = TextAlign.center
            color = Color.black
            borderBottomStyle = BorderStyle.solid
            borderBottomWidth = 2.px
        }

        private val tagName by css {
            transition(duration = .2.s)
            height = 1.5.em
            width = 100.pct
            lineHeight = LineHeight(height.value)
            textAlign = TextAlign.left
            display = Display.flex
            alignItems = Align.center
            justifyContent = JustifyContent.start
        }

        val labelUnFocused by css {
            +tagName
            position = Position.absolute
            fontSize = 0.8.em
            bottom = 0.pct
        }

        val labelFocused by css {
            +tagName
            position = Position.absolute
            fontSize = 0.8.em
            bottom = 100.pct
        }
    }

    init {
        state = State(
            textValue = "",
            isFocused = p.value?.isNotBlank() == true
        )
    }

    override fun RBuilder.render(): dynamic = ThemeConsumer { theme ->
        styledDiv {
            css {
                color = theme.onBackgroundColor
                +root
            }

            styledDiv {
                css { +if (state.isFocused) labelFocused else labelUnFocused }
                props.icon?.let {
                    it {}
                    pre { +" " }
                }
                +props.label
            }

            styledInput {
                css {
                    outline = Outline.none
                    +input
                    color = Color.inherit
                    borderBottomColor = theme.primaryColor
                }

                attrs {
                    id = props.name
                    name = props.name
                    props.value?.let { defaultValue = it }
                    type = if (props.type == InputType.tel) InputType.number else props.type
                    if (state.isFocused) placeholder = props.hint
                    required = props.isRequired
                    onChangeFunction = {
                        state.textValue = (document.getElementById(id) as HTMLInputElement).value
                    }

                    onFocusFunction = {
                        setState { isFocused = true }
                    }

                    onBlurFunction = {
                        setState { isFocused = textValue.isNotEmpty() }
                    }
                }

                props.data?.forEach { (key, value) ->
                    attrs["data-$key"] = value
                }
            }
        }
    }
}

fun RBuilder.FlatTextInput(
    name: String,
    label: String = name,
    hint: String = "",
    type: InputType = InputType.text,
    icon: RClass<IconProps>? = null,
    value: String? = null,
    isRequired: Boolean = true,
    data: Map<String, Any>? = null
) = child(FlatTextInput::class.js, Props(name, label, hint, value, type, icon, isRequired, data)) {}
