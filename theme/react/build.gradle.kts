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
                api(project(":theme-css"))
                api(project(":reakt-core"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.reakt.get(),
    description = "A theme engine for kotlin/react"
)
