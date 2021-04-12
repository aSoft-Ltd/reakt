package reakt

import kotlinx.html.DIV
import react.RBuilder
import styled.StyledDOMBuilder

inline fun <T> RBuilder.List(
    data: List<T>,
    cols: String = "1fr",
    gap: String = "1em",
    crossinline builder: StyledDOMBuilder<DIV>.(T) -> Unit
) = Grid(cols, gap) {
    data.forEach { builder(it) }
}