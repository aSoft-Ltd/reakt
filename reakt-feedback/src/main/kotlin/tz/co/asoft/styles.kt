package tz.co.asoft

import kotlinx.css.*
import styled.StyleSheet

internal val wrapper: CSSBuilder.() -> Unit = {
    width = 100.pct
    display = Display.flex
    justifyContent = JustifyContent.center
    alignItems = Align.center
    flexDirection = FlexDirection.column
}