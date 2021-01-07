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
                api(project(":reakt-core"))
                api(project(":reakt-icons"))
                api("tz.co.asoft:theme-react:${vers.asoft.theme}")
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Buttons of the Reakt lib"
)