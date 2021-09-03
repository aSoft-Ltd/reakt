plugins {
    alias(jetbrains.plugins.kotlin.js)
    alias(asoft.plugins.library)
    alias(nexus.plugins.publish)
    signing
}

kotlin {
    js(IR) { browserLib() }

    sourceSets {
        val main by getting {
            dependencies {
                api(kotlinw.react.core)
                api(npm("react-icons", "3.10.0"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "A kotlin js wrapper for the react-icons React lib"
)