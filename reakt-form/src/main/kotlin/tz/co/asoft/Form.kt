package tz.co.asoft

import kotlinx.html.FORM
import react.RBuilder
import styled.StyledDOMBuilder
import styled.styledForm

fun RBuilder.Form(builder: StyledDOMBuilder<FORM>.(ReactTheme) -> Unit) = HTMLFormBuilder().apply {
    ThemeConsumer { theme ->
        styledForm {
            attrs.onSubmitForm { executeSubmit(this) }
            builder(theme)
        }
    }
}