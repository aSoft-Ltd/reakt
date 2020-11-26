package ui

import kotlinx.coroutines.delay
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RProps
import react.RState
import styled.styledButton
import styled.styledDiv
import styled.styledP
import tz.co.asoft.Component
import tz.co.asoft.ContainedButton
import tz.co.asoft.FlexBox
import tz.co.asoft.Grid
import ui.Counter.Props
import ui.Counter.State

internal class Counter(p: Props) : Component<Props, State>(p) {
    class Props(val value: Int) : RProps
    class State(var value: Int) : RState

    init {
        state = State(p.value ?: 0)
    }

    fun increment() = syncState {
        delay(1000)
        value++
    }

    fun decrement() = syncState {
        delay(1000)
        value--
    }

    override fun RBuilder.render(): dynamic = styledDiv {
        styledButton {
            attrs {
                id = "plus"
                onClickFunction = { increment() }
            }
            +"+"
        }
        styledP {
            attrs.id = "value"
            +"${state.value}"
        }
        styledButton {
            attrs {
                id = "sub"
                onClickFunction = { decrement() }
            }
            +"-"
        }
    }
}

fun RBuilder.Counter(initialValue: Int = 0) = child(Counter::class.js, Props(initialValue)) {}