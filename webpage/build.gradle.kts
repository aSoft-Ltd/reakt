plugins {
    kotlin("js")
    id("tz.co.asoft.application") version "0.0.2"
}

konfig {
    debug(

    )
}

dependencies {
    api(project(":reakt-core"))
}