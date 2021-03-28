package reakt.navigation

import react.RBuilder
import reakt.CodeBlock
import reakt.FlexBox
import reakt.Grid

fun RBuilder.NavigationDrawer() = Grid {
    FlexBox {
        +"Sample"
    }
    CodeBlock {
        +"""
            class Person(val name: String)
        """.trimIndent()
    }
}