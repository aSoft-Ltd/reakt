plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api(project(":reakt-feedback"))
}

aSoftOSSLibrary(
    version = vers.asoft.reakt,
    description = "A non opinionated icon props"
)

