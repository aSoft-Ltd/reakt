package reakt

import react.*
import react.router.dom.RouteResultProps

abstract class AbstractModuleRoute(
    val permits: List<String>,
    val path: String,
    val scope: String,
    val render: (props: RouteResultProps) -> ReactElement?
)

fun <T : Props> ModuleRoute(
    path: String,
    permits: List<String>,
    scope: String,
    builder: RBuilder.(props: RouteResultProps) -> Unit
): AbstractModuleRoute {
    val render: (RouteResultProps) -> ReactElement? = {
        buildElement { builder(it) }
    }
    return object : AbstractModuleRoute(
        permits = permits,
        path = path,
        scope = scope,
        render = render
    ) {}
}