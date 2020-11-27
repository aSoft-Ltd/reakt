package ui

import kotlinext.js.jsObject
import kotlinx.coroutines.delay
import tz.co.asoft.asyncTest
import ui.enzyme.EnzymeAdapterReact16
import ui.enzyme.configure
import ui.enzyme.shallow
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

external interface MochaConfig {
    var timeout: Int
}

external object mocha {
    fun timeout(value: Int)
    fun setup(config: MochaConfig)
}

class CounterTest {
    @BeforeTest
    fun setup_enzyme() {
        mocha.setup(jsObject { timeout = 30000 })
        configure { adapter = EnzymeAdapterReact16() }
    }

    @Test
    @Ignore
    fun should_render_counter_component() = asyncTest {
        val wrapper = shallow { Counter(5) }
        console.log(wrapper.debug())
        wrapper.find("#plus").simulate("click")
        delay(10000)
        var state: Counter.State
        state = wrapper.state()
        assertEquals(6, state.value)
        wrapper.find("#sub").simulate("click")
        delay(10000)
        state = wrapper.state()
        assertEquals(5, state.value)
    }
}