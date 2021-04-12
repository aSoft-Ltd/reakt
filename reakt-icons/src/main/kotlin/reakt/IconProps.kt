package reakt

import react.RProps

external interface IconProps : RProps {
    var size: Int // in px
    var color: String
    var className: String
}