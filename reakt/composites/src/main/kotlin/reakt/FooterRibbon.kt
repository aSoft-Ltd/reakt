package reakt

import kotlinx.css.*
import react.RBuilder
import react.dom.a
import react.dom.div
import styled.css
import styled.styledDiv
import kotlinx.extensions.justifySelf
import kotlinx.extensions.onDesktop
import kotlinx.extensions.onMobile
import kotlin.js.Date

fun RBuilder.FooterRibbon(entityName: String) = Grid(cols = "auto auto") {
    css {
        padding(horizontal = 1.em, vertical = 0.5.em)
        onDesktop {
            gridTemplateColumns = GridTemplateColumns("auto auto")
        }
        onMobile {
            gridTemplateColumns = GridTemplateColumns("1fr")
            children {
                justifySelf = JustifyContent.center
            }
        }
    }

    div { +"Copyright ${169.toChar()} ${Date().getFullYear()} - $entityName" }

    styledDiv {
        css { onDesktop { justifySelf = JustifyContent.end } }
        +"Site by: "
        a(href = "https://asoft.co.tz") { +"aSoft Ltd" }
    }
}