package reakt

import kotlinx.html.InputType
import react.RBuilder
import react.ElementType

fun RBuilder.TextInput(
    name: String,
    label: String = name,
    hint: String = "",
    type: InputType = InputType.text,
    icon: ElementType<IconProps>? = null,
    value: String? = null,
    isRequired: Boolean = true,
    data: Map<String, Any>? = null
) = FlatTextInput(name, label, hint, type, icon, value, isRequired, data)
