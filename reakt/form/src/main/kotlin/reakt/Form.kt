package reakt

import kotlinx.extensions.onSubmitForm
import kotlinx.html.FORM
import react.RBuilder
import styled.StyledDOMBuilder
import styled.styledForm
import theme.ReactTheme
import theme.ThemeConsumer

fun RBuilder.Form(builder: StyledDOMBuilder<FORM>.(ReactTheme) -> Unit) = HTMLFormBuilder().apply {
    ThemeConsumer { theme ->
        styledForm {
            attrs.onSubmitForm { executeSubmit(this) }
            builder(theme)
        }
    }
}