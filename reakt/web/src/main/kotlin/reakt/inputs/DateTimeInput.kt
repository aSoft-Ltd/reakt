package reakt

import kotlinx.css.*
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
import styled.StyleSheet
import styled.css
import styled.styledDiv
import styled.styledInput
import theme.ThemeConsumer
import theme.onBackgroundColor
import theme.primaryColor
import kotlinx.extensions.UIID
import kotlinx.extensions.to
import react.dom.attrs
import kotlin.js.Date
import kotlin.lazy

external interface DateTimeInputProps : Props {
    var name: String
    var label: String
    var hint: String
    var type: InputType
    var value: Date?
    var data: Map<String, Any>?
    var isRequired: Boolean
}

class DateTimeInputState : State {
    var textValue = ""
    var isFocused = false
}

@JsExport
class DateTimeInput(p: DateTimeInputProps) : RComponent<DateTimeInputProps, DateTimeInputState>(p) {
    companion object styles : StyleSheet("date-time-input-styles") {
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
        state = DateTimeInputState()
    }

    private val INPUT_ID by lazy { UIID.getId("date") }

    override fun RBuilder.render(): dynamic = styledDiv {
        css { +root }

        styledDiv {
            css {
                if (state.isFocused) {
                    +labelFocused
                } else {
                    +labelUnFocused
                }
            }
            +props.label
        }


        ThemeConsumer { theme ->
            styledInput {
                attrs {
                    id = INPUT_ID.value
                    if (state.isFocused) {
                        placeholder = props.hint
                    }
                    name = props.name
                    required = props.isRequired

                    props.value?.let { defaultValue = it.toISOString().substring(0, 10) }
                    type = if (state.textValue.isEmpty() && !state.isFocused) InputType.text else props.type

                    onChangeFunction = { e ->
                        e.target?.to<HTMLInputElement>()?.let {
                            state.textValue = it.value
                        }
                    }

                    onFocusFunction = {
                        setState { isFocused = true }
                    }

                    onBlurFunction = {
                        setState {
                            isFocused = textValue.isNotEmpty()
                        }
                    }
                }

                props.data?.forEach { (k, v) ->
                    attrs["data-$k"] = v
                }

                css {
                    outline = Outline.none
                    +input
                    color = theme.onBackgroundColor
                    borderBottomColor = theme.primaryColor
                }
            }
        }
    }
}

fun RBuilder.DateTimeInput(
    name: String,
    label: String = name,
    hint: String = "",
    type: InputType = InputType.date,
    value: Date? = null,
    data: Map<String, Any>? = null,
    isRequired: Boolean = true
) = child(DateTimeInput::class) {
    attrs.name = name
    attrs.label = label
    attrs.hint = hint
    attrs.type = type
    attrs.value = value
    attrs.data = data
    attrs.isRequired = isRequired
}
