package reakt

import kotlinx.css.em
import kotlinx.css.minHeight
import kotlinx.css.pct
import kotlinx.css.width
import react.*
import react.dom.attrs
import styled.css
import styled.styledSource
import styled.styledVideo

external interface VideoPlayerProps : Props {
    var src: String
    var controls: Boolean
}

@JsExport
class VideoPlayer(p: VideoPlayerProps) : RComponent<VideoPlayerProps, State>(p) {
    override fun RBuilder.render(): dynamic = styledVideo {
        attrs { controls = props.controls }
        css {
            width = 100.pct
            minHeight = 10.em
        }

        styledSource {
            attrs.src = props.src
        }
    }
}

fun RBuilder.VideoPlayer(
    src: String,
    controls: Boolean = true
) = child(VideoPlayer::class) {
    attrs.src = src
    attrs.controls = controls
}