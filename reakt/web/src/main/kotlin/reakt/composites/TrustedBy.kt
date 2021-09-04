package reakt

import kotlinx.css.TextAlign
import kotlinx.css.textAlign
import react.RBuilder
import react.dom.br
import styled.css
import theme.clazz

fun RBuilder.TrustedBy(num: String) = Grid { theme ->
    css {
        +theme.text.h2.clazz
        textAlign = TextAlign.center
    }
    +"Trusted By"
    br { }
    +num
    br { }
    +"Clients"
}