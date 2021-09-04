package reakt

import react.ElementType

sealed class AButton<T>(val name: String, val icon: ElementType<IconProps>?, val handler: (T) -> Unit) {
    class Contained<T>(name: String, icon: ElementType<IconProps>? = null, handler: (T) -> Unit) : AButton<T>(name, icon, handler)
    class Outlined<T>(name: String, icon: ElementType<IconProps>? = null, handler: (T) -> Unit) : AButton<T>(name, icon, handler)
    class Text<T>(name: String, icon: ElementType<IconProps>? = null, handler: (T) -> Unit) : AButton<T>(name, icon, handler)
}