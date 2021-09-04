package reakt

import kotlinx.css.*
import react.RBuilder
import styled.css
import styled.styledDiv
import theme.clazz
import kotlinx.extensions.justifySelf
import kotlinx.extensions.onDesktop
import kotlinx.extensions.onMobile

class Intro(
    val heading: String,
    val body: String,
    val image: String
)

fun RBuilder.Introduction(intro: Intro) = Grid { theme ->
    css {
        onDesktop {
            gridTemplateColumns = GridTemplateColumns("2fr 1fr")
            gap = 5.em
            padding(horizontal = 20.pct)
        }

        onMobile {
            gridTemplateColumns = GridTemplateColumns("1fr")
            gap = 1.em
            padding(horizontal = 0.5.em)
        }
    }
    Grid(rows = "auto auto", gap = "1em") {
        css {
            alignSelf = Align.center
        }
        styledDiv {
            css {
                justifySelf = JustifyContent.center
                +theme.text.h2.clazz
            }
            +intro.heading
        }

        styledDiv {
            css {
                +theme.text.body1.clazz
                textAlign = TextAlign.justify
            }
            +intro.body
        }
    }

    AspectRationDiv { Image(src = intro.image, radius = 10.px) }
}