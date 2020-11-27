pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

rootProject.name = "reakt"

include(":reakt-core")
include(":reakt-icons")
include(":reakt-buttons")
include(":reakt-layouts")
include(":reakt-feedback")
include(":reakt-media")
include(":reakt-navigation")
include(":reakt-inputs")
include(":reakt-text")
include(":reakt-tables")
include(":reakt-composites")
include(":webpage")
