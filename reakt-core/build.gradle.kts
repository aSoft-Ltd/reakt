plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    js(IR) { browserLib() }

    sourceSets {
        val main by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${vers.kotlinx.coroutines}")
                api("tz.co.asoft:kotlinx-extensions:${vers.asoft.kotlinx_extensions}")
                api("org.jetbrains:kotlin-react:${vers.wrappers.react}")
                api("org.jetbrains:kotlin-styled:${vers.wrappers.styled}")
                api("org.jetbrains:kotlin-react-router-dom:${vers.wrappers.react_router_dom}")
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "A react wrapper tool library for kotlin-react"
)