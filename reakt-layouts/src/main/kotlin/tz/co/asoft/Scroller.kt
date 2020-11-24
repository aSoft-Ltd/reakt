package tz.co.asoft

import react.RClass

external interface ScrollerProps : StyledProps

@JsModule("simplebar-react")
@JsNonModule
external object SimpleBarReact {
    val default: RClass<ScrollerProps>
}
//@JsName("default")
//internal external val SimpleBarReact: RClass<ScrollerProps>