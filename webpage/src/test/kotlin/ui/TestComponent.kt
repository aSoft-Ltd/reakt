package ui

import react.functionComponent
import reakt.Grid
import styled.styledDiv
import ui.enzyme.EnzymeAdapterReact16
import ui.enzyme.configure
import ui.enzyme.shallow
import kotlin.test.BeforeTest
import kotlin.test.Test
import react.Props as RProps

val TestComp = functionComponent<RProps> {
    styledDiv { +"Test Comp" }
}

class TestComponent {

    @BeforeTest
    fun initializa_enzyme() {
        configure { adapter = EnzymeAdapterReact16() }
    }

    @Test
    fun should_render_a_test_comp() {
        val wrapper = shallow {
            Grid("1fr 1fr", "1fr 1fr") {
                for (i in 1..8) styledDiv {
                    +"Div $i"
                }
            }
        }
        console.log(wrapper.debug())
    }
}