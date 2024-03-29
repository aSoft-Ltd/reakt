package reakt

import kotlinx.css.*
import kotlinx.extensions.onDesktop
import kotlinx.extensions.onMobile
import react.Props
import react.fc
import react.router.dom.withRouter
import reakt.widgets.Installation
import reakt.widgets.Output
import reakt.widgets.Usage
import styled.css
import styled.styledDiv
import styled.styledImg
import theme.ThemeConsumer
import theme.primaryColor

private val HomeHook = fc<Props> { props ->
    ThemeConsumer { theme ->
        Surface(bgImageUrl = "bg.jpg", overlayColor = theme.primaryColor.withAlpha(0.9)) {
            css { centerContent() }
            Grid {
                css {
                    width = LinearDimension.auto
                    padding(vertical = 10.pct)
                    centerContent()
                }
                styledImg(src = "k+r.png") {
                    css {
                        width = 50.pct
                    }
                }
                styledDiv {
                    css { justifyContent = JustifyContent.center }
                    +"A kotlin first opinionated reactive UI library to be used with kotlin-react"
                }

                ContainedButton("Getting Started") {
                    props.history.push("/introduction")
                }
            }
        }

        Grid(gap = 0.em) {
            css {
                onDesktop {
                    gridTemplateColumns = GridTemplateColumns("1fr 1fr 1fr")
                    children {
                        padding(1.5.em)
                    }
                }
                onMobile { gridTemplateColumns = GridTemplateColumns("1fr") }
            }
            Surface { Installation() }
            Surface { Usage() }
            Surface { Output() }
        }
    }
}

val Home = WebPage("/reakt") {
    child(withRouter(HomeHook))
}