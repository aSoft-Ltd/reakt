package reakt

import react.createContext
import kotlinx.coroutines.flow.MutableStateFlow
import react.RBuilder
import kotlinx.extensions.isDesktop

enum class DrawerState {
    Opened, Closed
}

operator fun DrawerState.not() = when (this) {
    DrawerState.Opened -> DrawerState.Closed
    DrawerState.Closed -> DrawerState.Opened
}

/**
 * Toggles the drawer state and returns the a new [DrawerState]
 * @see DrawerState
 */
fun MutableStateFlow<DrawerState>.toggle() = let { value = !value;value }

val MainDrawerControllerContext by lazy {
    createContext(MutableStateFlow(if (isDesktop) DrawerState.Opened else DrawerState.Closed))
}

fun RBuilder.MainDrawerControllerConsumer(
    builder: RBuilder.(MutableStateFlow<DrawerState>) -> Unit
) = MainDrawerControllerContext.Consumer(builder)