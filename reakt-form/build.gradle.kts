plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    js(IR) { library() }
    sourceSets {
        val main by getting {
            dependencies {
                api("tz.co.asoft:theme-react:${vers.asoft.theme}")
                api("tz.co.asoft:reakt-core:${vers.asoft.reakt}")
                api(project(":form-html"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.form,
    description = "Form tools to work with Forms in react"
)
