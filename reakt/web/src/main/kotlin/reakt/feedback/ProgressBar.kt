package reakt

import kotlinext.js.jsObject
import kotlinx.coroutines.*
import kotlinx.css.*
import kotlinx.css.properties.boxShadowInset
import react.*
import react.State as RState
import styled.css
import styled.styledProgress
import reakt.ProgressBar.State
import theme.*
import kotlinx.extensions.onDesktop
import kotlinx.extensions.onMobile
import react.dom.attrs

external interface ProgressBarProps : Props {
    var value: Number?
}

@JsExport
class ProgressBar private constructor(p: ProgressBarProps) : Component<ProgressBarProps, State>(p) {

    class State(
        var dir: Int = 1,
        var value: Double
    ) : RState

    init {
        state = State(dir = 1, value = 0.0)
    }

    private fun nextIndeterminateValue() = launch {
        delay(10)
        setState {
            if (value + dir > 100 || value + dir < 0) {
                dir *= -1
            }
            value += dir
        }
    }

    override fun componentWillUnmount() {
        cancel()
    }

    override fun RBuilder.render(): dynamic = ThemeConsumer { theme ->
        styledProgress {
            css {
                put("appearance", "none")
                val decs = arrayOf("-webkit-", "-moz-", "")
                decs.forEach {
                    "&::${it}progress-bar" {
                        backgroundColor = theme.primaryColor
                        borderRadius = 2.px
                        boxShadowInset(rgba(0, 0, 0, 0.25), blurRadius = 5.px, spreadRadius = 2.px)
                    }
                }

                decs.forEach {
                    "&::${it}progress-value" {
                        backgroundColor = theme.primaryVariantColor
                        borderRadius = 2.px
                    }
                }
                onDesktop {
                    height = 5.px
                }

                onMobile {
                    height = 10.px
                }
            }
            attrs {
                value = (props.value ?: state.value.apply {
                    nextIndeterminateValue()
                }).toString()
                max = "100"
            }
        }
    }
}

fun RBuilder.ProgressBar(value: Number? = null) = AspectRationDiv {
    child(ProgressBar::class) { attrs.value = value }
}