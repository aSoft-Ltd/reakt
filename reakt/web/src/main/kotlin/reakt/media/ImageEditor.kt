package reakt

import kotlinx.css.Align
import kotlinx.css.LinearDimension
import kotlinx.css.alignSelf
import kotlinx.css.pct
import org.w3c.dom.url.URL
import org.w3c.files.File
import react.*
import styled.css

external interface ImageEditorProps : Props {
    var file: File
    var textFontSize: LinearDimension
    var onCancel: (() -> Unit)
    var aspectRatio: Float
    var onSubmit: (File) -> Unit
}

class ImageEditorState(
    var ui: ImageEditor.UI
) : State

@JsExport
class ImageEditor private constructor() : RComponent<ImageEditorProps, ImageEditorState>() {
    sealed class UI {
        object Loading : UI()
        class Editing(val url: String) : UI()
    }

    init {
        state = ImageEditorState(UI.Loading)
    }

    lateinit var imageUrl: String
    override fun componentDidMount() {
        imageUrl = URL.createObjectURL(props.file)
        setState { ui = UI.Editing(imageUrl) }
    }

    override fun componentWillUnmount() {
        URL.revokeObjectURL(imageUrl)
    }

    private fun RBuilder.PreviewAndActions(url: String) = Grid(cols = "1fr 1fr 1fr") {
        css {
            children { alignSelf = Align.center }
        }
        ProfilePic(
            radius = 50.pct,
            name = "A",
            textFontSize = props.textFontSize,
            aspectRatio = props.aspectRatio,
            src = url
        )
        OutlinedButton("Cancel", onClick = props.onCancel)
        ContainedButton("Submit") { props.onSubmit(props.file) }
    }

    override fun RBuilder.render(): dynamic = when (val ui = state.ui) {
        UI.Loading -> ProgressBar()
        is UI.Editing -> Grid(rows = "1fr auto") {
            ProfilePic("A", ui.url, props.aspectRatio, textFontSize = props.textFontSize)
            PreviewAndActions(ui.url)
        }
    }
}

fun RBuilder.ImageEditor(
    file: File,
    textFontSize: LinearDimension,
    onCancel: () -> Unit,
    onSubmit: (File) -> Unit,
    aspectRatio: Float
) = child(ImageEditor::class) {
    attrs.file = file
    attrs.textFontSize = textFontSize
    attrs.onCancel = onCancel
    attrs.aspectRatio = aspectRatio
    attrs.onSubmit = onSubmit
}