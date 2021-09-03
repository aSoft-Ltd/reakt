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
                api(project(":reakt-buttons"))
                api(project(":reakt-layouts"))
                api(project(":reakt-icons"))
            }
        }
    }
}


aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Feedback components of the Reakt lib"
)