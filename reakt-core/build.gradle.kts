plugins {
    kotlin("js") version "1.4.10"
    id("tz.co.asoft.library") version "0.0.7"
}

kotlin {
    js(IR) {
        browser()
    }
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${versions.kotlinx.coroutines}")
    api("tz.co.asoft:kotlinx-extensions:${vers.asoft.kotlinx_extensions}")
    api("org.jetbrains:kotlin-react:${vers.wrappers.react}")
    api("org.jetbrains:kotlin-styled:${vers.wrappers.styled}")
    api("org.jetbrains:kotlin-react-router-dom:${vers.wrappers.react_router_dom}")
}