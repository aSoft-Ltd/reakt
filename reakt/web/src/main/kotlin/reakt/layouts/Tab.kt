package reakt

import kotlinx.html.DIV
import react.ElementType
import styled.StyledDOMBuilder
import theme.ReactTheme

class Tab(
    val name: String,
    val icon: ElementType<*>? = null,
    val isCloseable: Boolean = false,
    val content: StyledDOMBuilder<DIV>.(ReactTheme) -> Any
)