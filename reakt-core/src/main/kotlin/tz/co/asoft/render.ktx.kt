package tz.co.asoft

import org.w3c.dom.Element
import react.RBuilder
import react.dom.render

fun Element?.setContent(builder: RBuilder.() -> Unit): Unit = render(this, handler = builder)