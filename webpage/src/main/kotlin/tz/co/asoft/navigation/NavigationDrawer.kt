@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import react.RBuilder

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