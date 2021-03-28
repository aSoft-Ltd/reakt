package reakt

import kotlinx.coroutines.flow.MutableStateFlow
import react.RBuilder
import styled.css
import tz.co.asoft.*

fun RBuilder.ReaktAppBar(drawerController: MutableStateFlow<DrawerState>) = ThemeConsumer { theme ->
    NavigationAppBar(
        bgColor = theme.primaryColor,
        color = theme.onPrimaryColor,
        drawerController = drawerController,
        middle = { theme ->
            css { +theme.text.h1.clazz }
            +"Reakt"
        },
        right = {
            Switch("Theme", "dark", color = theme.onPrimaryColor) {
                currentTheme.value = if (currentTheme.value.color == AquaGreenPallet) {
                    DarkGrayTheme()
                } else {
                    AquaGreenTheme()
                }
            }
        }
    )
}