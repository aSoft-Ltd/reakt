package reakt

import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RClass
import styled.css
import styled.styledButton
import tz.co.asoft.ThemeConsumer

fun RBuilder.TextButton(name: String, icon: RClass<IconProps>? = null, onClick: (() -> Unit)? = null) = ThemeConsumer { theme ->
    styledButton {
        css { +styles.text(theme) }
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