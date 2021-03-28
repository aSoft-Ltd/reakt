package reakt

import kotlinx.css.*
import react.RBuilder
import reakt.FlexBox
import reakt.Grid
import styled.css
import styled.styledHr

fun RBuilder.TextBetweenLine(
    value: String,
    lineHeight: LinearDimension = 1.px,
    gap: LinearDimension = 0.5.em
) = Grid("1fr auto 1fr", gap = gap) {
    css { alignItems = Align.center }
    FlexBox { styledHr { css { width = 100.pct; height = lineHeight } } }
    FlexBox { +value }
    FlexBox { styledHr { css { width = 100.pct; height = lineHeight } } }
}
