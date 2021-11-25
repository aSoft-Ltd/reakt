package unit

import kotlin.test.Test
import kotlin.test.assertEquals

class AdditionTest {
    @Test
    fun should_add_1_and_2_toequal_3() {
        assertEquals(3, 1 + 2)
    }

    @Test
    fun should_fail() {
        assertEquals(4, 2 + 2)
    }
}