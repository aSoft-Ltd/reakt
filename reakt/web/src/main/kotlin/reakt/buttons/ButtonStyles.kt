package reakt

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.border
import kotlinx.extensions.justifySelf
import styled.StyleSheet
import theme.*

internal object ButtonStyles : StyleSheet("button") {
    private val button_layout by css {
        display = Display.grid
        gap = 0.3.em
        alignItems = Align.center
    }

    val button_layout_with_icon by css {
        +button_layout
        gridTemplateColumns = GridTemplateColumns("auto auto")
    }

    val button_layout_no_icon by css {
        +button_layout
        gridTemplateColumns = GridTemplateColumns("1fr")
    }

    private val wrapper by css {
        borderRadius = 4.px
        padding(0.4.em)
        cursor = Cursor.pointer
        put("font-size", "inherit")
        outline = Outline.none
        justifySelf = JustifyContent.center
    }

    fun text(theme: ReactTheme): RuleSet = {
        +wrapper
        border = "none"
        backgroundColor = theme.primaryColor.withAlpha(0.05)
        color = Color.inherit
        hover {
            backgroundColor = theme.primaryColor.withAlpha(0.3)
            color = Color.inherit
        }
    }

    fun contained(theme: ReactTheme): RuleSet = {
        +wrapper
        backgroundColor = theme.primaryColor
        border(2.px, BorderStyle.solid, theme.primaryColor)
        color = theme.onPrimaryColor
        hover {
            backgroundColor = theme.primaryVariantColor
            border(2.px, BorderStyle.solid, theme.primaryVariantColor)
        }
    }

    fun outlined(theme: ReactTheme): RuleSet = {
        +wrapper
        backgroundColor = Color.transparent
        border(2.px, BorderStyle.solid, theme.primaryColor)
        color = Color.inherit
        hover {
            backgroundColor = theme.primaryColor.withAlpha(0.3)
        }
    }

    fun secondary(theme: ReactTheme): RuleSet = {
        +wrapper
        backgroundColor = theme.backgroundColor
        border(2.px, BorderStyle.solid, theme.primaryColor)
        color = theme.onBackgroundColor
        hover {
            backgroundColor = theme.backgroundColor
            color = theme.onBackgroundColor
            border(2.px, BorderStyle.solid, theme.primaryColor)
        }
    }
}