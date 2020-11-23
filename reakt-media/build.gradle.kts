plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api(project(":reakt-feedback"))
    api(project(":reakt-buttons"))
}

aSoftLibrary(
    version = vers.asoft.reakt,
    description = "Media components of the Reakt lib"
)