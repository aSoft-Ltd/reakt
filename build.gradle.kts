import org.jetbrains.kotlin.gradle.dsl.KotlinJsProjectExtension

plugins {
    kotlin("js") version vers.kotlin apply false
    id("tz.co.asoft.library") version vers.asoft.builders apply false
    id("io.codearte.nexus-staging") version vers.nexus_staging apply false
    id("tz.co.asoft.applikation") version vers.asoft.builders apply false
}
