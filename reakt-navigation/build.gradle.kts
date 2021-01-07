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
