package tz.co.asoft

import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RClass
import styled.css
import styled.styledButton

fun RBuilder.OutlinedButton(name: String, icon: RClass<IconProps>? = null, onClick: (() -> Unit)? = null) = ThemeConsumer { theme ->
    styledButton {
        css { +styles.outlined(theme) }
        attrs {
            type = if (onClick == null) ButtonType.submit else {
                onClickFunction = { it.preventDefault(); onClick() }
                ButtonType.button
            }
        }
        attrs["data-name"] = name
        ButtonLayout(name, icon)
    }
}