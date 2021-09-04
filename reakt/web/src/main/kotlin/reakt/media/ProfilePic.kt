package reakt

import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onLoadFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.files.File
import react.*
import styled.css
import styled.styledImg
import styled.styledInput
import theme.primaryColor
import kotlinx.extensions.UIID
import kotlinx.extensions.justifySelf
import kotlinx.extensions.to
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import org.w3c.files.get
import react.dom.attrs
import kotlin.lazy
import kotlin.Float

external interface ProfilePicProps : Props {
    var name: String
    var src: String?
    var aspectRatio: Float
    var radius: LinearDimension
    var textFontSize: LinearDimension
    var onEdit: ((File) -> Any)?
}

class ProfilePicState(var loading: Boolean) : State

@JsExport
class ProfilePic private constructor() : RComponent<ProfilePicProps, ProfilePicState>() {

    init {
        state = ProfilePicState(true)
    }

    private val IMAGE_INPUT_ID by lazy { UIID.getId("profile-pic") }

    private val imageInput get() = IMAGE_INPUT_ID.get<HTMLInputElement>()

    override fun componentWillUnmount() {
        IMAGE_INPUT_ID.release()
    }

    private fun RBuilder.InvisibleImageInput() = styledInput(type = InputType.file) {
        css {
            position = Position.absolute
            left = 0.px
            top = 0.px
            visibility = Visibility.hidden
        }
        attrs {
            id = IMAGE_INPUT_ID.value
            accept = "image/*"
            onChangeFunction = { ev ->
                ev.target?.to<HTMLInputElement>()?.files?.get(0)?.let {
                    props.onEdit?.invoke(it)
                }
            }
        }
    }

    private fun RBuilder.LoadingWidget() = Grid { theme ->
        css {
            width = 100.pct
            height = 100.pct
            position = Position.absolute
            border(width = 2.px, color = theme.primaryColor, style = BorderStyle.solid, borderRadius = props.radius)
            children {
                justifySelf = JustifyContent.center
                alignSelf = Align.center
            }
        }
        ProgressBar()
    }

    override fun RBuilder.render(): dynamic = AspectRationDiv(props.aspectRatio) {
        InvisibleImageInput()
        props.onEdit?.let {
            attrs.onClickFunction = { imageInput.click() }
        }
        val src = props.src
        if (src == null || src.isBlank()) {
            TextProfilePic(props.name, textFontSize = props.textFontSize, radius = props.radius)
        } else {
            styledImg(src = props.src, alt = props.name) {
                css {
                    width = 100.pct
                    height = 100.pct
                    borderRadius = props.radius
                    cursor = Cursor.pointer
                }
                attrs.onLoadFunction = { setState { loading = false } }
            }
            if (state.loading) {
                LoadingWidget()
            }
        }
    }
}

fun RBuilder.ProfilePic(
    name: String,
    src: String? = null,
    aspectRatio: Float = 1f / 1f,
    radius: LinearDimension = 10.px,
    textFontSize: LinearDimension = 1.rem,
    onEdit: ((File) -> Any)? = null
) = child(ProfilePic::class) {
    attrs.name = name
    attrs.src = src
    attrs.aspectRatio = aspectRatio
    attrs.radius = radius
    attrs.textFontSize = textFontSize
    attrs.onEdit = onEdit
}