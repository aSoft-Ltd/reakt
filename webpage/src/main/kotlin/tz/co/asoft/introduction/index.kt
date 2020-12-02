@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import kotlinx.css.GridTemplateColumns
import kotlinx.css.em
import kotlinx.css.gridTemplateColumns
import react.RBuilder
import react.RProps
import styled.css
import styled.styledDiv
import tz.co.asoft.introduction.Buttons

private fun RBuilder.Introduction() = Surface(margin = 0.5.em) { theme ->
    Grid {
        styledDiv {
            css {
                +theme.text.h1.clazz
                centerContent()
            }
            +"Introduction"
        }

        FlexBox {
            css { centerContent() }
            +"An opinionated suite of kotlin first react ui libs"
        }

        FlexBox {
            css {
                centerContent()
                +theme.text.h2.clazz
            }
            +"Contents"
        }

        Grid {
            css {
                onMobile { gridTemplateColumns = GridTemplateColumns("1fr") }
                onDesktop { gridTemplateColumns = GridTemplateColumns("1fr 1fr") }
            }
            Buttons()
            TextInputs()
            Icons()
            Feedbacks()
            Layouts()
            OtherInputs()
            Media()
            Tables()
        }
    }
}

val Introduction = WebPage<RProps>("/") { Introduction() }