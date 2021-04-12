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
                api(project(":reakt-core"))
                api(project(":reakt-icons"))
                api("tz.co.asoft:theme-react:${vers.asoft.theme}")
                api(npm("simplebar-react","2.2.0"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Layouts of the Reakt lib"
)