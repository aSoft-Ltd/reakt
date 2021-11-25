plugins {
    alias(jetbrains.plugins.kotlin.js) apply false
    alias(asoft.plugins.library) apply false
    alias(nexus.plugins.publish)
    alias(asoft.plugins.deploy)
}

deployToSonatype {
    version = asoft.versions.reakt.get()
}