package reakt

import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import theme.ReactTheme
import theme.ThemeConsumer

@Deprecated(
    "Use gap as a Linear Dimension",
    ReplaceWith("Grid(cols, rows, LinearDimension(gap), builder)", "kotlinx.css.LinearDimension")
)
fun RBuilder.Grid(
    cols: String = "1fr",
    rows: String = "1fr",
    gap: String,
    builder: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit
) = Grid(cols, rows, LinearDimension(gap), builder)

fun RBuilder.Grid(
    cols: String = "1fr",
    rows: String = "1fr",
    gap: LinearDimension = 1.em,
    builder: StyledDOMBuilder<DIV>.(ReactTheme) -> Unit
) = ThemeConsumer { theme ->
    styledDiv {
        css {
            display = Display.grid
            gridTemplateColumns = GridTemplateColumns(cols)
            gridTemplateRows = GridTemplateRows(rows)
            width = 100.pct
            this.gap = gap
        }
        builder(theme)
    }
}