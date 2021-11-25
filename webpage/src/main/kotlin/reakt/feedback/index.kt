package reakt.feedback

import reakt.FaAd
import reakt.NavMenu
import reakt.WebPage

private object links {
    val feedbackhome = "/feedback"
}

val FeedbackMenus = listOf(
    NavMenu("Feedback", icon = FaAd, link = links.feedbackhome, scope = "*")
)

val FeedbackPages = listOf(
    WebPage(links.feedbackhome) { FeedbackHome() }
)

