package reakt

import kotlinext.js.require
import react.RBuilder
import react.RHandler

private var simpleBarCssLoaded = false

fun RBuilder.Scroller(handler: RHandler<ScrollerProps>) = SimpleBarReact.default {
    if (!simpleBarCssLoaded) {
        require("simplebar/dist/simplebar.min.css")
        simpleBarCssLoaded = true
    }
    handler()
}