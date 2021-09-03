package reakt

import kotlinx.css.*
import kotlinx.extensions.*

inline fun CssBuilder.centerContent() {
    alignItems = Align.center
    alignContent = Align.center
    textAlign = TextAlign.center
    justifyItems = JustifyContent.center
    justifyContent = JustifyContent.center
}


inline fun CssBuilder.centerSelf() {
    justifySelf = JustifyContent.center
}

var CssBuilder.justifyItems: JustifyContent
    inline set(value) {
        put("justify-items", value.toString())
    }
    inline get() {
        throw Exception("Justify items is write only property")
    }