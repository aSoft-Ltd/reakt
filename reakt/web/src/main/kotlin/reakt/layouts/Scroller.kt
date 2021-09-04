package reakt

import react.ComponentClass

external interface ScrollerProps : StyledProps

@JsModule("simplebar-react")
@JsNonModule
external object SimpleBarReact {
    val default: ComponentClass<ScrollerProps>
}