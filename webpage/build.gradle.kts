import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("js")
    id("tz.co.asoft.applikation")
}

version = asoft.versions.reakt.get()

repositories {
    publicRepos()
}

applikation {
    debug()
    release()
}

kotlin {
    js(IR) {
        browserApp {
            commonWebpackConfig {
                cssSupport.enabled = true
                outputFileName = "main.bundle.js"
                devServer = KotlinWebpackConfig.DevServer(
                    open = false,
                    static = mutableListOf(project.file("build/processedResources/js/main").absolutePath)
                )
            }
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(asoft.applikation.runtime)
                implementation(project(":reakt-web"))
                implementation(npm("@types/enzyme", "3.10.8", generateExternals = false))
                implementation(npm("@types/enzyme-adapter-react-16", "1.0.6", generateExternals = false))
            }
        }

        val test by getting {
            dependencies {
                implementation(asoft.expect.core)
                implementation(npm("enzyme", "3.11.0"))
                implementation(npm("enzyme-adapter-react-16", "1.15.5"))
            }
        }
    }
}
