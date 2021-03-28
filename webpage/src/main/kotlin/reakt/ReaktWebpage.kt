package reakt

import kotlinx.coroutines.flow.MutableStateFlow
import react.RBuilder
import react.RProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch
import tz.co.asoft.konfig

private val drawerState = MutableStateFlow(DrawerState.Closed)

fun RBuilder.ReaktWebpage(moduleGroups: Map<String, List<NavMenu>>, pages: List<WebPage<out RProps>>) = NavigationDrawer(
    drawerState = drawerState,
    drawer = {
        val version: String by konfig()
        NavPane(
            drawerController = drawerState,
            moduleGroups = moduleGroups,
            header = { CompanyHeader("/k+r.png", "Reakt $version") }
        )
    },
    content = {
        ReaktAppBar(drawerState)
        switch {
            pages.forEach {
                route(it.route, exact = true, render = it.render)
            }
            redirect(to = "/")
        }
        FooterRibbon("aSoft Ltd")
    }
)