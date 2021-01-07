package tz.co.asoft

import kotlinx.css.Color
import react.RBuilder
import react.RClass

fun RBuilder.WarningBox(
    title: String = "Warning",
    primaryColor: Color? = null,
    surfaceColor: Color? = null,
    onSurfaceColor: Color? = null,
    shadowColor: Color? = null,
    icon: RClass<IconProps> = FaExclamationCircle,
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