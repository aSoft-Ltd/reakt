package reakt

import kotlinx.css.*
import kotlinx.css.Color
import react.RBuilder
import react.ElementType
import styled.css
import styled.styledP
import theme.*

fun RBuilder.ErrorBox(
    exception: Throwable,
    primaryColor: Color? = null,
    surfaceColor: Color? = null,
    onSurfaceColor: Color? = null,
    shadowColor: Color? = null,
    actions: List<AButton<Unit>> = listOf(),
    icon: ElementType<IconProps> = FaTimesCircle
) = ThemeConsumer { theme ->
    FeedbackBox(
        title = exception.message ?: "Unknown Error",
        primaryColor = primaryColor ?: theme.primaryColor,
        surfaceColor = surfaceColor ?: theme.errorColor,
        onSurfaceColor = onSurfaceColor ?: theme.onErrorColor,
        shadowColor = shadowColor ?: theme.onBackgroundColor,
        actions = actions,
        icon = icon
    ) {
        Accordion("Reason: ${exception.cause?.message ?: "Unknown"}") {
            var mainException = true
            for (chunk in exception.stackTraceToStringChunks()) {
                val title = chunk.exceptionTitle()
                Accordion((if (mainException) "" else "Caused by: ") + title.toCuteString()) {
                    for (line in chunk.lines(title)) styledP {
                        css { marginBottom = 0.2.em }
                        +line
                    }
                }
                mainException = false
            }
        }
    }
}

private fun String.lines(title: String): List<String> {
    val lines = replace(title, "").replace("at ", "At ").split("At ").map {
        "At $it"
    }
    return lines.subList(1, lines.size)
}

private fun String.toCuteString(): String {
    val splits = split(": ")
    return splits[1]
}

private fun String.exceptionTitle() = split(" at ").getOrNull(0) ?: ""

private fun Throwable.stackTraceToStringChunks() = stackTraceToString().split("Caused by:")