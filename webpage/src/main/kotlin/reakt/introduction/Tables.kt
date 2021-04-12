package reakt.introduction

import kotlinx.css.*
import kotlinx.css.properties.boxShadow
import react.RBuilder
import reakt.*
import styled.css
import styled.styledHr
import theme.clazz
import kotlinx.extensions.onDesktop

private class Person(val name: String, val age: Int)

fun RBuilder.Tables() = Grid(gap = "0em") { theme ->
    css {
        padding(0.5.em)
        boxShadow(Color.gray, blurRadius = 4.px, spreadRadius = 1.px)
        borderRadius = 4.px
        onDesktop {
            gridRow = GridRow("6/7")
            gridColumn = GridColumn("1/3")
        }
    }
    Grid {
        css {
            +theme.text.h2.clazz
            padding(0.5.em)
        }
        +"Tables"
        styledHr {
            css {
                width = 100.pct
                centerSelf()
            }
        }
    }
    val data = listOf(
        Person("Andy", 26),
        Person("Lamax", 27),
        Person("John", 23),
        Person("Doe", 43),
        Person("Jane", 32)
    )

    val cols = listOf<Column<Person>>(
        Column("Name") { it.name },
        Column("Age") { it.age }
    )
    ReactTable(
        data = data,
        columns = cols,
        defaultPageSize = 5
    )

    FoldableTable(
        data = data,
        columns = cols,
        defaultPageSize = 5
    )
}