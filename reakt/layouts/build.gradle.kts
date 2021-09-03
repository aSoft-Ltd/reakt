plugins {
    alias(jetbrains.plugins.kotlin.js)
    alias(asoft.plugins.library)
    alias(nexus.plugins.publish)
    signing
}

kotlin {
    js(IR) { browserLib() }

    sourceSets {
        val main by getting {
            dependencies {
                api(project(":reakt-core"))
                api(project(":reakt-icons"))
                api(project(":theme-react"))
                api(project(":reakt-styles"))
                api(npm("simplebar-react", "2.2.0"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.reakt.get(),
    description = "Layouts of the Reakt lib"
)