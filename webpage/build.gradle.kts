plugins {
    kotlin("js")
    id("tz.co.asoft.applikation")
}

group = "tz.co.asoft.reakt"
version = vers.asoft.reakt

applikation {
    debug()
    release()
}

kotlin {
    js(IR) { browserApp() }

    sourceSets {
        val main by getting {
            dependencies {
                implementation("tz.co.asoft:applikation-runtime:${vers.asoft.builders}")
                implementation(project(":reakt-navigation"))
                implementation(project(":reakt-text"))
                implementation(project(":reakt-inputs"))
                implementation(project(":reakt-composites"))
                implementation(project(":reakt-tables"))
                implementation(npm("@types/enzyme", "3.10.8", generateExternals = false))
                implementation(npm("@types/enzyme-adapter-react-16", "1.0.6", generateExternals = false))
            }
        }

        val test by getting {
            dependencies {
                implementation("tz.co.asoft:test:1.0.1")
                implementation(npm("enzyme", "3.11.0"))
                implementation(npm("enzyme-adapter-react-16", "1.15.5"))
            }
        }
    }
}

