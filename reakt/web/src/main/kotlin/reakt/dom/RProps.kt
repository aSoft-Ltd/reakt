package reakt

import react.Props
import react.router.dom.RouteResultProps

val <T : Props> T.withRouter get() = unsafeCast<RouteResultProps>()

val <T : Props> T.history get() = withRouter.history

val <T : Props> T.location get() = withRouter.location

val <T : Props> T.match get() = withRouter.match