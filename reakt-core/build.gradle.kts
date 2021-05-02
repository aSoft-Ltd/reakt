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
                api(asoft("kotlinx-extensions-browser", vers.asoft.kotlinx_extensions))

                api(kotlinx("coroutines-core-js", vers.kotlinx.coroutines))
//                api(kotlinx("html-js", vers.kotlinx.html)) {
//                    version { strictly(vers.kotlinx.html) }
//                }

                api(wrapper("react", vers.wrappers.react))
                api(wrapper("styled", vers.wrappers.styled))
                api(wrapper("react-router-dom", vers.wrappers.react_router_dom))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "A react wrapper tool library for kotlin-react"
)