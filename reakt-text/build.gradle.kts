plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api(project(":reakt-layouts"))
    api(project(":reakt-icons"))
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "Text components of the Reakt lib"
)