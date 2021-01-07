plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    js(IR) { library(forNodeJs = false) }

    sourceSets {
        val main by getting {
            dependencies {
                api(project(":reakt-feedback"))
                api(project(":reakt-buttons"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Media components of the Reakt lib"
)