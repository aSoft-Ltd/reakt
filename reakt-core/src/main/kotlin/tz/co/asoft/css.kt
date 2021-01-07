package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import org.w3c.dom.css.CSS

inline fun CSSBuilder.centerContent() {
    alignItems = Align.center
    alignContent = Align.center
    textAlign = TextAlign.center
    justifyItems = JustifyContent.center
    justifyContent = JustifyContent.center
}


inline fun CSSBuilder.centerSelf() {
    justifySelf = JustifyContent.center
}

var CSSBuilder.justifyItems: JustifyContent
    inline set(value) {
        put("justify-items", value.toString())
    }
    inline get() {
        throw Exception("Justify items is write only property")
    }