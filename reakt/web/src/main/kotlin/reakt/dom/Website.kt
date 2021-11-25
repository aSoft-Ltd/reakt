package reakt

import react.RBuilder
import react.router.dom.BrowserRouter
import react.router.dom.Redirect
import react.router.dom.Route
import react.router.dom.Switch

fun RBuilder.Website(pages: List<WebPage>) = BrowserRouter {
    Switch {
        for (page in pages) Route {
            attrs {
                path = arrayOf(page.route)
                exact = true
                strict = true
                render = { props -> with(page) { render(props) } }
            }
        }
        Redirect { attrs.to = "/" }
    }
}

inline fun RBuilder.Website(vararg pages: WebPage) = Website(pages.toList())