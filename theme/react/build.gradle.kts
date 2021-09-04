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
                api(project(":theme-css"))
                api(project(":reakt-core"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.reakt.get(),
    description = "A theme engine for kotlin/react"
)
