package reakt

import kotlinx.css.*
import kotlinx.css.FontWeight
import react.RBuilder
import styled.css
import styled.styledDiv

fun RBuilder.KeyValue(key: String, value: String) = styledDiv {
    css {
        display = Display.grid
        gridTemplateColumns = GridTemplateColumns("1fr 1fr")
    }
    styledDiv {
        css {
            marginLeft = 1.em
            fontWeight = FontWeight.bold
        }
        +"$key:"
    }
    styledDiv {
        +value
    }
}

inline fun RBuilder.KeyValue(pair: Pair<String, String>) = KeyValue(pair.first, pair.second)