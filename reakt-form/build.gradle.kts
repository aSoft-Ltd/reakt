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
                api("tz.co.asoft:theme-react:${vers.asoft.theme}")
                api(project(":reakt-core"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Form tools to work with Forms in react"
)
