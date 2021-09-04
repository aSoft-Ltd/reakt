package reakt

import kotlinx.coroutines.flow.MutableStateFlow
import react.RBuilder
import react.RProps
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch
import applikation.konfig
import reakt.feedback.FeedbackPages
import reakt.navigation.NavigationPages

private val drawerState = MutableStateFlow(DrawerState.Closed)

fun RBuilder.ReaktWebpage(
    moduleGroups: Map<String, List<NavMenu>>,
    pages: List<WebPage>
) = NavigationDrawer(
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
            for (p in pages) route(p.route, exact = true, render = p.builder)
            redirect(to = "/reakt")
        }
        FooterRibbon("aSoft Ltd")
    }
)