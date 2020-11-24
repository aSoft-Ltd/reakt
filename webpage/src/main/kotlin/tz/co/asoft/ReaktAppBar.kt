package tz.co.asoft

import kotlinx.coroutines.flow.MutableStateFlow
import react.RBuilder
import styled.css

fun RBuilder.ReaktAppBar(drawerController: MutableStateFlow<DrawerState>) = NavigationAppBar(
    drawerController = drawerController,
    middle = { theme ->
        css { +theme.text.h1.clazz }
        +"Reakt Components"
    }
)