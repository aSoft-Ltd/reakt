@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.properties.boxShadow
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import styled.styledHr

fun RBuilder.Layouts() = Grid(gap = "0em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
        onDesktop {
            gridRow = GridRow("4/5")
            gridColumn = GridColumn("1/3")
        }
    }
    Grid {
        css {
            +theme.text.h2.clazz
            padding(0.5.em)
        }
        +"Layouts"
        styledHr {
            css {
                width = 100.pct
                centerSelf()
            }
        }
    }
    Tabs(
        Tab("Grid", FaChessBoard) {
            Wrapper {
                Grid(cols = (1..10).joinToString(" ") { "1fr" }, rows = "auto") {
                    (10..49).forEach {
                        Button("Cell $it")
                    }
                }
            }
        },
        Tab("FlexBox", FaBars) {
            Wrapper {
                FlexBox {
                    repeat(10) {
                        styledDiv {
                            css { padding(1.em) }
                            Button("Cell ${it + 1}")
                        }
                    }
                }
            }
        },
        Tab("Tabs", FaIcons) {
            Wrapper {
                Tabs(*((1..4).map { tab ->
                    Tab("Tab ${tab + 1}") {
                        +"Body of Tab ${tab + 1}"
                    }
                }).toTypedArray())
            }
        },
        Tab("List", FaBars) {
            Wrapper {
                List((1..5).toList()) { item ->
                    styledDiv {
                        css {
                            padding(0.2.em)
                        }
                        +"Item $item"
                        if (item != 5) styledHr {
                            css {
                                width = 98.pct
                                centerSelf()
                            }
                        }
                    }
                }
            }
        },
        Tab("KeyValue", FaUserFriends) {
            Wrapper {
                KeyValue("Name" to "Anderson")
                KeyValue("Email" to "test@email.com")
                KeyValue("Phone" to "+255752748674")
            }
        },
        Tab("Scroller") {
            Wrapper {
                Scroller {
                    styledDiv {
                        +"Lorem ipsum dolor sit amet. ".repeat(500)
                    }
                }
            }
        }
    )
}

private fun StyledDOMBuilder<DIV>.Wrapper(builder: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        width = 100.pct
        height = 30.vh
    }
    builder()
}