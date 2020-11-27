package tz.co.asoft

import react.RBuilder
import react.RProps
import react.router.dom.browserRouter
import react.router.dom.redirect
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.Website(pages: List<WebPage<out RProps>>) = browserRouter {
    switch {
        for(page in pages) route(path = page.route, exact = true, strict = true, render = page.render)
        redirect(to = "/")
    }
}

inline fun RBuilder.Website(vararg pages: WebPage<out RProps>) = Website(pages.toList())