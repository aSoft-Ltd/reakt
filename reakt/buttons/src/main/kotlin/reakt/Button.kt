package reakt

import react.RBuilder
import react.ElementType

fun RBuilder.Button(
    name: String,
    type: UIType = UIType.Contained,
    icon: ElementType<IconProps>? = null,
    onClick: (() -> Unit)? = null
) = when (type) {
    UIType.Contained -> ContainedButton(name, icon, onClick)
    UIType.Outlined -> OutlinedButton(name, icon, onClick)
    UIType.Text -> TextButton(name, icon, onClick)
}