package reakt

import kotlinx.css.*
import react.RBuilder
import styled.css
import styled.styledDiv
import tz.co.asoft.*

@Deprecated("Use LoadingBox")
fun RBuilder.Loader(text: String) = ThemeConsumer { theme ->
    styledDiv {
        css { +wrapper }

        styledDiv {
            css { color = theme.primaryColor }
            LoadingSvg()
        }

        styledDiv {
            css {
                margin(1.em)
                color = theme.onSurfaceColor
            }
            +text
        }
    }
}