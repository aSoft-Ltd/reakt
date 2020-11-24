plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api("org.jetbrains:kotlin-react:${vers.wrappers.react}")
    api(npm("react-icons", "3.10.0"))
}

aSoftLibrary(
    version = vers.asoft.theme,
    description = "A kotlin js wrapper for the react-icons React lib"
)