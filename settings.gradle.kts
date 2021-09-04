pluginManagement {
    repositories {
        google()
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
    enableFeaturePreview("VERSION_CATALOGS")
    dependencyResolutionManagement {
        versionCatalogs {
            listOf("asoft", "jetbrains", "kotlinw", "kotlinx", "nexus").forEach {
                create(it) { from(files("gradle/versions/$it.toml")) }
            }
        }
    }
}

rootProject.name = "reakt"

listOf("core", "css", "react").forEach {
    include(":theme-$it")
    project(":theme-$it").projectDir = File("theme/$it")
}

listOf("core", "web", "icons").forEach {
    include(":reakt-$it")
    project(":reakt-$it").projectDir = File("reakt/$it")
}

include(":webpage")