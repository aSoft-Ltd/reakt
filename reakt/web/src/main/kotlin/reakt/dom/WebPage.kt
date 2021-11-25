package reakt

import react.RBuilder
import react.ReactElement
import react.createElement
import react.router.dom.RouteComponentProps

open class WebPage(
    val route: String,
    val builder: RBuilder.(RouteComponentProps) -> Unit
) {
    val render: (RouteComponentProps) -> ReactElement? = {
        createElement { builder(it) }
    }
}