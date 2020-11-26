package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import org.w3c.dom.css.CSS

inline fun CSSBuilder.centerContent() {
    textAlign = TextAlign.center
    justifyContent = JustifyContent.center
}


inline fun CSSBuilder.centerSelf() {
    justifySelf = JustifyContent.center
}