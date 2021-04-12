package reakt

import kotlinx.css.Color
import kotlinx.css.RuleSet
import kotlinx.css.backgroundColor
import kotlinx.css.color
import theme.ReactTheme
import theme.dropdown_clazz

private val follow_theme: RuleSet = {
    backgroundColor = Color.transparent
    color = Color.inherit
}

internal fun table(theme: ReactTheme): RuleSet = {
    color = Color.inherit
    child("div .rt-noData") {
        +follow_theme
    }

    child("div .pagination-bottom .-pagination .-center .-pageInfo .-pageJump input") {
        +follow_theme
    }

    child("div .pagination-bottom .-pagination .-center span select") {
        +follow_theme
        +theme.dropdown_clazz
    }
}