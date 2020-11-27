package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadowInset
import kotlinx.html.CODE
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledCode
import styled.styledPre

fun RBuilder.CodeBlock(builder: StyledDOMBuilder<CODE>.(ReactTheme) -> Unit) = ThemeConsumer { theme ->
    styledPre {
        styledCode {
            css {
                backgroundColor = theme.backgroundColor
                color = theme.onBackgroundColor
                borderRadius = 5.px
                display = Display.block
                boxShadowInset(theme.onBackgroundColor.withAlpha(0.3), blurRadius = 5.px)
                padding(20.px)
            }
            builder(theme)
        }
    }
}