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
                api(project(":reakt-layouts"))
                api(project(":reakt-buttons"))
                api(project(":reakt-icons"))
                api(npm("react-table", "6.10.3"))
                api(npm("file-loader","6.2.0"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Navigation components of the Reakt lib"
)