plugins {
    kotlin("js")
    id("tz.co.asoft.application")
}

repositories {
    publicRepos()
}

group = "tz.co.asoft.reakt"
version = vers.asoft.reakt

konfig {
    debug(
        "app" to "Rea.kt"
    )
    release(
        "app" to "Rea.kt"
    )
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig { cssSupport.enabled = true }
        }
        binaries.executable()
    }
}

dependencies {
    implementation("tz.co.asoft:konfig:${vers.asoft.konfig}")
    implementation(project(":reakt-navigation"))
    implementation(project(":reakt-text"))
}