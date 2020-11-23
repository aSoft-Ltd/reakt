plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api(project(":reakt-feedback"))
}

aSoftLibrary(
    version = vers.asoft.theme,
    description = "A non opinionated icon props"
)

