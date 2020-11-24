package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import org.w3c.dom.css.CSS

inline fun CSSBuilder.centerContent() {
    textAlign = TextAlign.center
    justifyContent = JustifyContent.center
}

inline val CSSBuilder.centerContent: CSSBuilder.() -> Unit
    get() = {
        textAlign = TextAlign.center
        justifyContent = JustifyContent.center
    }

inline fun CSSBuilder.centerSelf() {
    justifySelf = JustifyContent.center
}

inline val CSSBuilder.centerSelf: CSSBuilder.() -> Unit
    get() = {
        justifySelf = JustifyContent.center
    }

inline fun CSSBuilder.card(elevation: LinearDimension = 4.px) {
    boxShadow(Color.gray,)
}