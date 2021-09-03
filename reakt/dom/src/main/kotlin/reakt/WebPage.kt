package reakt

import react.RBuilder
import react.ReactElement
import react.buildElement
import react.router.dom.RouteResultProps

open class WebPage(
    val route: String,
    val builder: RBuilder.(RouteResultProps) -> ReactElement?
) {
    val render: (RouteResultProps) -> ReactElement? = {
        buildElement { builder(it) }
    }
}