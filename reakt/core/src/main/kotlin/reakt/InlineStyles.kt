package reakt

import kotlinx.css.CssBuilder
import react.Props
import react.RElementBuilder
import styled.toStyle

external interface StyledProps : Props {
    /**
     * Inline style tag
     */
    var style: dynamic
}

fun RElementBuilder<StyledProps>.css(builder: CssBuilder.() -> Unit) {
    attrs.style = CssBuilder().apply(builder).toStyle()
}

fun RElementBuilder<*>.style(builder: CssBuilder.() -> Unit) {
    attrs.asDynamic().style = CssBuilder().apply(builder).toStyle()
}