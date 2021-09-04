package reakt

import kotlinx.css.*
import kotlinx.css.Color
import kotlinx.css.TextAlign
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onKeyDownFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.KeyboardEvent
import react.RBuilder
import styled.css
import styled.styledDiv
import styled.styledInput
import kotlinx.browser.document
import theme.ThemeConsumer
import theme.onPrimaryColor
import theme.primaryColor
import theme.primaryVariantColor
import kotlinx.extensions.UIID
import react.dom.attrs

fun RBuilder.SearchInput(hint: String, css: RuleSet, onSearch: (String) -> Unit) = ThemeConsumer { theme ->
    styledDiv {
        css {
            border = "solid 1px ${theme.primaryColor}"
            borderRadius = 1.em
            color = Color.inherit
            width = 100.pct
            height = 2.em
            display = Display.flex
            minWidth = 15.em
            alignItems = Align.stretch
            +css
        }
        SearchIcon()
        InputField(hint, onSearch)
        SearchButton(onSearch)
    }
}

private val ID by lazy { UIID.getId("asoft-reakt-search-box") }

private fun RBuilder.SearchIcon() = ThemeConsumer { theme ->
    styledDiv {
        css {
            width = 10.pct
            display = Display.flex
            justifyContent = JustifyContent.center
            alignItems = Align.center
            color = Color.inherit
        }
        FaSearch {}
    }
}

private fun RBuilder.InputField(hint: String, onSearch: (String) -> Unit) = styledInput {
    css {
        width = 65.pct
        borderStyle = BorderStyle.none
        outline = Outline.none
        backgroundColor = Color.transparent
        color = Color.inherit
        textAlign = TextAlign.center
    }
    attrs {
        placeholder = hint
        id = ID.value
    }
    attrs.onKeyDownFunction = {
        val e = it.unsafeCast<KeyboardEvent>()
        if (e.keyCode == 13) {
            onSearch((document.getElementById(ID.value).unsafeCast<HTMLInputElement>()).value)
        }
    }
}

private fun RBuilder.SearchButton(onSearch: (String) -> Unit) = ThemeConsumer { theme ->
    styledDiv {
        css {
            hover {
                backgroundColor = theme.primaryVariantColor
                color = theme.onPrimaryColor
            }
            color = theme.onPrimaryColor
            display = Display.flex
            width = 25.pct
            backgroundColor = theme.primaryColor
            borderTopRightRadius = 1.em
            borderBottomRightRadius = 1.em
            textAlign = TextAlign.center
            alignItems = Align.center
            justifyContent = JustifyContent.center
            cursor = Cursor.pointer
        }
        attrs.onClickFunction = { onSearch((document.getElementById(ID.value).unsafeCast<HTMLInputElement>()).value) }
        +"Go"
    }
}