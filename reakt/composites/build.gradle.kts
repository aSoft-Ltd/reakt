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
                api(project(":reakt-layouts"))
                api(project(":reakt-media"))
                api(project(":reakt-icons"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Navigation components of the Reakt lib"
)
