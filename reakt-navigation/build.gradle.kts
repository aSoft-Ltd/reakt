plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api(project(":reakt-layouts"))
    api(project(":reakt-media"))
    api(project(":reakt-icons"))
}

aSoftLibrary(
    version = vers.asoft.reakt,
    description = "Navigation components of the Reakt lib"
)
