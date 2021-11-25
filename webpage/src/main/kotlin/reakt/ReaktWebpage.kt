package reakt

import applikation.konfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.css.CssBuilder
import react.RBuilder
import react.router.dom.Redirect
import react.router.dom.Route
import react.router.dom.Switch

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
        Switch {
            for (p in pages) Route {
                attrs {
                    path = arrayOf(p.route)
                    exact = true
                    render = p.render
                }
            }
            Redirect { attrs.to = "/reakt" }
        }
        FooterRibbon("aSoft Ltd")
    }
)