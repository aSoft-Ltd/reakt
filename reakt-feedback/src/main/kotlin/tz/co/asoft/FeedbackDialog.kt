package tz.co.asoft

import react.*
import styled.styledDiv

@JsExport
class FeedbackDialog private constructor() : RComponent<RProps, RState>() {
    override fun RBuilder.render(): dynamic = styledDiv {
        +"Works"
    }
}

fun RBuilder.FeedbackDialog(handler: RHandler<RProps>) = child(FeedbackDialog::class, handler)