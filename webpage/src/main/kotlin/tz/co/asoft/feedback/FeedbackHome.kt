@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import kotlinx.browser.window
import react.*

val levelThree = Error("Level 3 exception")
val deepLevel = RuntimeException("Deep nested cause", levelThree)
val testingDialog = IllegalStateException("Testing Error Dialog", deepLevel)

@JsExport
class FeedbackHome private constructor() : Component<RProps, FeedbackHome.State>() {
    class State(var ui: UI) : RState
    sealed class UI {
        object Loading : UI()
        object Warning : UI()
        object Success : UI()
        class Error(val exception: Throwable) : UI()
    }

    init {
        state = State(UI.Loading)
    }

    override fun RBuilder.render() = Grid {
        Grid("1fr 1fr 1fr 1fr") {
            ContainedButton("Loading") { setState { ui = UI.Loading } }
            ContainedButton("Warning") { setState { ui = UI.Warning } }
            ContainedButton("Success") { setState { ui = UI.Success } }
            ContainedButton("Error") { setState { ui = UI.Error(Exception("Jaribio")) } }
        }
        when (val ui = state.ui) {
            UI.Loading -> LoadingBox()
            UI.Warning -> WarningBox()
            UI.Success -> SuccessBox()
            is UI.Error -> ErrorBox(ui.exception)
        }
    }
}

fun RBuilder.FeedbackHome() = child(FeedbackHome::class) {}