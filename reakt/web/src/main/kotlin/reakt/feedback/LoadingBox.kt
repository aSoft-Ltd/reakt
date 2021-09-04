package reakt

import kotlinx.css.Color
import react.RBuilder
import react.ElementType
import theme.*

fun RBuilder.LoadingBox(
    title: String = "Loading . . .",
    primaryColor: Color? = null,
    surfaceColor: Color? = null,
    onSurfaceColor: Color? = null,
    shadowColor: Color? = null,
    icon: ElementType<IconProps> = FaHourglassHalf,
    actions: List<AButton<Unit>> = listOf(),
) = ThemeConsumer { theme ->
    FeedbackBox(
        title = title,
        primaryColor = primaryColor ?: theme.primaryColor,
        surfaceColor = surfaceColor ?: theme.surfaceColor,
        onSurfaceColor = onSurfaceColor ?: theme.onSurfaceColor,
        shadowColor = shadowColor ?: theme.onBackgroundColor,
        actions = actions,
        icon = icon
    ) {}
}

/**
 * @param level in %
 */
fun RBuilder.LoadingBox(
    title: String = "Loading . . .",
    level: Int,
    primaryColor: Color? = null,
    surfaceColor: Color? = null,
    onSurfaceColor: Color? = null,
    shadowColor: Color? = null,
    actions: List<AButton<Unit>> = listOf(),
) = LoadingBox(
    title = title,
    primaryColor = primaryColor,
    surfaceColor = surfaceColor,
    onSurfaceColor = onSurfaceColor,
    shadowColor = shadowColor,
    icon = when (level) {
        in 0..30 -> FaHourglassStart
        in 31..70 -> FaHourglassHalf
        else -> FaHourglassEnd
    },
    actions = actions
)