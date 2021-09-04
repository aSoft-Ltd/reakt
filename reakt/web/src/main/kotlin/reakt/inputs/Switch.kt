package reakt

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.dom.defaultValue
import styled.css
import styled.styledDiv
import styled.styledInput
import styled.styledLabel
import theme.*
import kotlinx.extensions.to
import kotlinx.extensions.justifySelf

fun RBuilder.Switch(
    name: String,
    value: String,
    label: String = name,
    checked: Boolean = false,
    disabled: Boolean = false,
    required: Boolean = false,
    data: Map<String, Any>? = null,
    color: Color? = null,
    onChanged: ((Boolean) -> Unit)? = null
) = ThemeConsumer { theme ->
    styledLabel {
        css {
            display = Display.grid
            gridTemplateColumns = GridTemplateColumns("auto 1fr")
            gap = 0.2.em
            cursor = Cursor.pointer
            children {
                alignSelf = Align.center
                justifySelf = JustifyContent.start
            }
        }
        styledInput(type = InputType.checkBox, name = name) {
            css {
                position = Position.relative
                cursor = Cursor.pointer
                width = 3.em
                height = 1.5.em
                put("appearance", "none")
                backgroundColor = (color ?: theme.primaryColor).withAlpha(0.5)
                outline = Outline.none
                borderRadius = 1.5.em
                transition(duration = 0.5.s)
                boxShadowInset(
                    offsetX = 0.px,
                    offsetY = 0.px,
                    blurRadius = 2.px,
                    color = (color ?: theme.backgroundColor).withAlpha(0.2)
                )
                checked {
                    backgroundColor = color ?: theme.primaryColor
                    before { left = 1.5.em }
                }
                before {
                    content = "".quoted
                    position = Position.absolute
                    width = 1.5.em
                    height = 1.5.em
                    borderRadius = 50.pct
                    top = 0.px
                    left = 0.px
                    backgroundColor = color ?: theme.primaryColor
                    boxShadow(
                        offsetX = 0.px,
                        offsetY = 0.px,
                        blurRadius = 2.px,
                        color = Color.inherit
                    )
                    transform { scale(1.1) }
                    transition(duration = .5.s)
                }
            }

            data?.forEach { (k, v) -> attrs["data-$k"] = v }
            attrs.defaultValue = value
            attrs.defaultChecked = checked
            attrs.readonly = disabled
            if (disabled) attrs.disabled = disabled
            attrs.required = required
            attrs.onChangeFunction = { ev ->
                ev.target?.to<HTMLInputElement>()?.checked?.let { onChanged?.invoke(it) }
            }
        }
        styledDiv {
            css {
                cursor = Cursor.pointer
                this.color = Color.inherit
            }
            +label
        }
    }
}