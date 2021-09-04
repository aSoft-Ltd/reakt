package ui.enzyme

import kotlinext.js.jsObject
import react.RBuilder
import react.buildElement

inline fun configure(config: EnzymeConfig.() -> Unit) = configure(jsObject<EnzymeConfig>(config))

inline fun shallow(builder: RBuilder.() -> Unit) = shallow(buildElement(builder))

inline fun mount(builder: RBuilder.() -> Unit) = mount(buildElement(builder))
