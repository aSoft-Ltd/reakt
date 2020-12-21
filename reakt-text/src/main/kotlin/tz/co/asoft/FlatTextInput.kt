package tz.co.asoft

import kotlinx.html.InputType
import react.RBuilder
import react.RClass

fun RBuilder.TextInput(
    name: String,
    label: String = name,
    hint: String = "",
    type: InputType = InputType.text,
    icon: RClass<IconProps>? = null,
    value: String? = null,
    isRequired: Boolean = true,
    data: Map<String, Any>? = null
) = FlatTextInput(name, label, hint, type, icon, value, isRequired, data)
