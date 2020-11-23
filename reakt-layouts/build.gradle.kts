plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api(project(":reakt-core"))
    api("tz.co.asoft:theme-react:${vers.asoft.theme}")
}

aSoftLibrary(
    version = vers.asoft.reakt,
    description = "Layouts of the Reakt lib"
)