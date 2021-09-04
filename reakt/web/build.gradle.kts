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
                api(project(":reakt-core"))
                api(project(":theme-react"))
                api(project(":reakt-icons"))
                api(kotlinw.react.router.dom)
                api(asoft.kotlinx.browser)
                api(kotlinw.css)
                api(npm("react-table", "6.10.3"))
                api(npm("file-loader","6.2.0"))
                api(npm("simplebar-react", "2.2.0"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.reakt.get(),
    description = "A react wrapper tool library for kotlin-react"
)
