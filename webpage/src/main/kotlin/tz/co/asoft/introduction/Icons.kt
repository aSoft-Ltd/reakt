@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadow
import react.RBuilder
import styled.css
import styled.styledHr

fun RBuilder.Icons() = Grid(gap = "0em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
        onDesktop {
            gridRow = GridRow("2/3")
        }
    }
    Grid {
        css {
            +theme.text.h2.clazz
            padding(0.5.em)
        }
        +"Icons"
        styledHr {
            css {
                width = 100.pct
                centerSelf()
            }
        }
    }
    Grid(cols = "1fr 1fr 1fr 1fr 1fr 1fr 1fr") {
        css {
            padding(0.5.em)
            color = theme.primaryColor
            onDesktop { fontSize = 3.em }
            onMobile { fontSize = 1.em }
        }
        Fa500Px {}
        FaAddressBook {}
        FaAdobe {}
        FaAngleDown {}
        FaAppStore {}
        FaBatteryFull {}
        FaApplePay {}
    }
}