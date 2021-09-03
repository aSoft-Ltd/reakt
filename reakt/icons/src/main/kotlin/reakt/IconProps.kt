package reakt

import react.Props

external interface IconProps : Props {
    var size: Int // in px
    var color: String
    var className: String
}