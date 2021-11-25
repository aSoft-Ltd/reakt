plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
//    iosTargets(false)

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":theme-core"))
                api(asoft.color.css)
                api(kotlinx.coroutines.core)
//                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${vers.kotlinx.coroutines}")
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.reakt.get(),
    description = "A platform/framework agnostic theme engine"
)