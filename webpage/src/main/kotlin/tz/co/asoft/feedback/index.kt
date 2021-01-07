@file:Suppress("PackageDirectoryMismatch")

package tz.co.asoft

import react.RProps

private object links {
    val feedbackhome = "/feedback"
}

val FeedbackMenus = listOf(
    NavMenu("Feedback", icon = FaAd, link = links.feedbackhome, scope = "*")
)

val FeedbackPages = listOf(
    WebPage<RProps>(links.feedbackhome) { FeedbackHome() }
)

