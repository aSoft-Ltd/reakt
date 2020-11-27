package tz.co.asoft

import kotlinx.coroutines.flow.MutableStateFlow
import react.RBuilder
import styled.css

fun RBuilder.ReaktAppBar(drawerController: MutableStateFlow<DrawerState>) = NavigationAppBar(
    drawerController = drawerController,
    middle = { theme ->
        css { +theme.text.h1.clazz }
        +"Reakt Components"
    },
    right = {
        Switch("Theme", "dark") {
            currentTheme.value = if (currentTheme.value.color == AquaGreenPallet) {
                DarkGrayTheme()
            } else {
                AquaGreenTheme()
            }
        }
    }
)