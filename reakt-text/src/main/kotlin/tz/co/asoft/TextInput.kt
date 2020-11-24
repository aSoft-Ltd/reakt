package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onBlurFunction
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onFocusFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.defaultValue
import react.dom.pre
import styled.css
import styled.styledDiv
import styled.styledInput
import tz.co.asoft.TextInput.Props
import tz.co.asoft.TextInput.State
import kotlinx.browser.document

private class TextInput(p: Props) : RComponent<Props, State>(p) {
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

    class State(
        var textValue: String,
        var isFocused: Boolean
    ) : RState

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
                +styles.root
            }

            styledDiv {
                css {
                    if (state.isFocused) {
                        +styles.labelFocused
                    } else {
                        +styles.labelUnFocused
                    }
                }
                props.icon?.let {
                    it {}
                    pre { +" " }
                }
                +props.label
            }

            styledInput {
                attrs {
                    id = props.name
                    name = props.name
                    props.value?.let { defaultValue = it }
                    type = if (props.type == InputType.tel) {
                        InputType.number
                    } else {
                        props.type
                    }

                    if (state.isFocused) {
                        placeholder = props.hint
                    }

                    required = props.isRequired

                    onChangeFunction = {
                        state.textValue = (document.getElementById(id) as HTMLInputElement).value
                    }

                    onFocusFunction = {
                        setState {
                            isFocused = true
                        }
                    }

                    onBlurFunction = {
                        setState {
                            isFocused = textValue.isNotEmpty()
                        }
                    }
                }

                props.data?.forEach { (key, value) ->
                    attrs["data-$key"] = value
                }

                css {
                    outline = Outline.none
                    +styles.input
                    color = Color.inherit
                    borderBottomColor = theme.primaryColor
                }
            }
        }
    }
}

fun RBuilder.TextInput(
    name: String,
    label: String = name,
    hint: String = "",
    type: InputType = InputType.text,
    icon: RClass<IconProps>? = null,
    value: String? = null,
    isRequired: Boolean = true,
    data: Map<String, Any>? = null
) = child(TextInput::class.js, Props(name, label, hint, value, type, icon, isRequired, data)) {}
