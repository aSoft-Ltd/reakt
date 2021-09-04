package reakt

import react.RBuilder
import react.ElementType
import react.dom.span
import styled.css
import styled.styledDiv

internal fun RBuilder.ButtonLayout(name: String, icon: ElementType<IconProps>?) = styledDiv {
    css {
        if (icon == null) {
            +ButtonStyles.button_layout_no_icon
        } else {
            +ButtonStyles.button_layout_with_icon
        }
    }
    icon?.let { it {} }
    span { +name }
}