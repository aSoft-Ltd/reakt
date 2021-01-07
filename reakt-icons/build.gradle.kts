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
                api("org.jetbrains:kotlin-react:${vers.wrappers.react}")
                api(npm("react-icons", "3.10.0"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "A kotlin js wrapper for the react-icons React lib"
)