plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

dependencies {
    api(project(":reakt-layouts"))
    api(project(":reakt-buttons"))
    api(project(":reakt-icons"))
    api(npm("react-table", "6.10.3"))
    api(devNpm("file-loader","6.2.0"))
}

aSoftLibrary(
    version = vers.asoft.reakt,
    description = "Navigation components of the Reakt lib"
)