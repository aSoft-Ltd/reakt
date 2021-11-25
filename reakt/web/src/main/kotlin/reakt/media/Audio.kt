package reakt

import kotlinext.js.jsObject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.extensions.UIID
import kotlinx.html.id
import org.w3c.dom.HTMLAudioElement
import react.RBuilder
import react.Props
import react.*
import styled.styledAudio
import styled.styledDiv
import kotlin.math.round

private external interface AudioProps : Props {
    var src: String
    var volume: Double
}

private external interface IScrollerProps : Props {
    var updater: StateFlow<Double>
}

private val Scroller = fc<IScrollerProps> { props ->
    val progress = props.updater.asState()
    styledDiv { +"${round(progress * 100)}%" }
}

private val Audio = fc<AudioProps> { props ->
    val id = UIID.getId("audio-player")
    useEffectOnce { cleanup { id.release() } }

    val progress = MutableStateFlow(0.0)
    val scope = useScope()

    styledAudio {
        attrs.src = props.src
        attrs.controls = true
        attrs.id = id.value
    }

    fun HTMLAudioElement.updateProgress() {
        progress.value = currentTime / duration
        if (!paused) {
            scope.launch {
                delay(500)
                updateProgress()
            }
        }
    }

    scope.launch {
        id.get<HTMLAudioElement>().apply {
            volume = props.volume
            onplaying = { updateProgress() }
            onpause = { updateProgress() }
            onseeked = { updateProgress() }
            onseeking = { updateProgress() }
        }
    }
}

/**
 * @param volume - [0..1], default: 0.5
 */
fun RBuilder.Audio(src: String, volume: Double = 0.5) = child(Audio, jsObject<AudioProps>().also {
    it.src = src
    it.volume = volume
}) {}