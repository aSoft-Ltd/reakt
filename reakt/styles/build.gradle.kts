plugins {
    alias(jetbrains.plugins.kotlin.js)
    alias(asoft.plugins.library)
    alias(nexus.plugins.publish)
    signing
}

kotlin {
    js(IR) { library() }

    sourceSets {
        val main by getting {
            dependencies {
                api(asoft.kotlinx.browser)
                api(kotlinw.css)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.reakt.get(),
    description = "A react wrapper tool library for kotlin-react"
)