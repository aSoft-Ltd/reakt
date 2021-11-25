plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    signing
}

kotlin {
    jvm { library() }
    js(IR) { library() }
//    nativeTargets(false)
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(asoft.color.core)
            }
        }
    }
}

aSoftOSSLibrary(
    version = asoft.versions.reakt.get(),
    description = "A platform/framework agnostic theme engine"
)