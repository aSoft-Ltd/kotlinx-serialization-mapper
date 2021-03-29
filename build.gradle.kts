plugins {
    kotlin("multiplatform") version "1.4.31"
    id("tz.co.asoft.library") version "1.3.0"
    id("io.codearte.nexus-staging") version "0.22.0"
    signing
}

object vers {
    object kotlinx {
        val serialization = "1.1.0"
    }

    object asoft {
        val mapper = "0.0.60"
        val test = "1.1.20"
    }
}

kotlin {
    multiplatformLib()
    js(IR) {
        browser {
            testTask { enabled = false }
        }
    }
    macosX64()
    ios()
    tvos()
    linuxArm64()
    linuxX64()
    linuxArm32Hfp()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:${vers.kotlinx.serialization}")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("test-core", vers.asoft.test))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.mapper,
    description = "A Kotlinx Serialization Extension for mapping between json objects and kotlin maps"
)