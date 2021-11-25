package reakt

import react.Props
import react.router.dom.RouteComponentProps

val <T : Props> T.withRouter get() = unsafeCast<RouteComponentProps>()

val <T : Props> T.history get() = withRouter.history

val <T : Props> T.location get() = withRouter.location

val <T : Props> T.match get() = withRouter.match