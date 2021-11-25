package reakt

import react.Props
import react.RBuilder
import react.ReactElement
import react.buildElement
import react.router.dom.RouteComponentProps

abstract class AbstractModuleRoute(
    val permits: List<String>,
    val path: String,
    val scope: String,
    val render: (props: RouteComponentProps) -> ReactElement?
)

fun <T : Props> ModuleRoute(
    path: String,
    permits: List<String>,
    scope: String,
    builder: RBuilder.(props: RouteComponentProps) -> Unit
): AbstractModuleRoute {
    val render: (RouteComponentProps) -> ReactElement? = {
        buildElement { builder(it) }
    }
    return object : AbstractModuleRoute(
        permits = permits,
        path = path,
        scope = scope,
        render = render
    ) {}
}