package ui

import kotlinx.coroutines.delay
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.dom.attrs
import reakt.Component
import styled.styledButton
import styled.styledDiv
import styled.styledP
import ui.Counter.State
import react.Props as RProps
import react.State as RState

external interface Props : RProps {
    var value: Int
}

internal class Counter(p: Props) : Component<Props, State>(p) {
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

fun RBuilder.Counter(initialValue: Int = 0) = child(Counter::class) {
    attrs.value = initialValue
}