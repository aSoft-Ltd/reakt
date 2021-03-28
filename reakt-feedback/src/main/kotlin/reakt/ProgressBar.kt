package reakt

import kotlinx.coroutines.*
import kotlinx.css.*
import kotlinx.css.properties.boxShadowInset
import react.*
import styled.css
import styled.styledProgress
import reakt.ProgressBar.Props
import reakt.ProgressBar.State
import theme.*
import tz.co.asoft.onDesktop
import tz.co.asoft.onMobile

@JsExport
class ProgressBar private constructor(p: Props) : Component<Props, State>(p) {
    class Props(val value: Number?) : RProps

    class State : RState {
        var dir = 1
        var value = 0.0
    }

    init {
        state = State()
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
    child(ProgressBar::class.js, Props(value)) {}
}