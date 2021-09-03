package reakt

import react.RBuilder
import react.RProps
import react.router.dom.browserRouter
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.Website(pages: List<WebPage>) = browserRouter {
    switch {
        for (page in pages) route(
            path = arrayOf(page.route),
            exact = true,
            strict = true,
            render = { props -> with(page) { builder(props) } })
        redirect(to = "/")
    }
}

inline fun RBuilder.Website(vararg pages: WebPage) = Website(pages.toList())