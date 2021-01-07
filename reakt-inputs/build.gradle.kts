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
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "A non opinionated icon props"
)

