package reakt

import kotlinx.html.DIV
import react.RClass
import styled.StyledDOMBuilder
import theme.ReactTheme

class Tab(
    val name: String,
    val icon: RClass<*>? = null,
    val isCloseable: Boolean = false,
    val content: StyledDOMBuilder<DIV>.(ReactTheme) -> Any
)