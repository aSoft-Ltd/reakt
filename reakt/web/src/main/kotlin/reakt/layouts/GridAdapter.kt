package reakt

import kotlinx.css.LinearDimension
import kotlinx.css.em
import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder

@Deprecated(
    "Use gap as a LinearDimension",
    ReplaceWith(
        "GridAdapter(data, cols, rows, LinearDimension(gap), builder)",
        "kotlinx.css.LinearDimension"
    )
)
fun <T> RBuilder.GridAdapter(
    data: List<T>,
    cols: String = "1fr",
    rows: String = "1fr",
    gap: String = "1em",
    builder: StyledDOMBuilder<DIV>.(T) -> Unit
) = GridAdapter(data, cols, rows, LinearDimension(gap), builder)

fun <T> RBuilder.GridAdapter(
    data: List<T>,
    cols: String = "1fr",
    rows: String = "1fr",
    gap: LinearDimension = 1.em,
    builder: StyledDOMBuilder<DIV>.(T) -> Unit
) = Grid(cols, rows, gap) {
    data.forEach { builder(it) }
}