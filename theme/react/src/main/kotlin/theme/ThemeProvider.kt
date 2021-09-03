package theme

import kotlinx.browser.document
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import react.*
import reakt.useScope

private class ThemeProviderProps(
    val observerFrom: StateFlow<ReactTheme>
) : PropsWithChildren {
    override var children: Array<out ReactNode>? = null
}

private val ThemeProvider = fc<ThemeProviderProps> { props ->
    var theme by useState(props.observerFrom.value)
    val scope = useScope()
    scope.launch { props.observerFrom.collect { theme = it } }
    ThemeProvider(theme) { props.children() }
}

private fun ReactTheme.imposeToDocument() = document.body?.style?.also {
    it.backgroundColor = backgroundColor.value
    it.color = onBackgroundColor.value
}

fun RBuilder.ThemeProvider(
    theme: ReactTheme,
    handler: RHandler<ProviderProps<ReactTheme>>
) = ThemeContext.Provider(theme, handler)

fun RBuilder.ThemeProvider(
    observerFrom: StateFlow<ReactTheme> = currentTheme,
    handler: RBuilder.() -> Unit
) = child(ThemeProvider, ThemeProviderProps(observerFrom), handler)