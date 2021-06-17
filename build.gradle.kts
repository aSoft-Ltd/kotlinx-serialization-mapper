plugins {
    kotlin("multiplatform") version "1.5.10"
    id("tz.co.asoft.library") version "1.3.30"
    id("io.codearte.nexus-staging") version "0.22.0"
    signing
}

object vers {
    object kotlinx {
        val serialization = "1.2.1"
    }

    object asoft {
        val mapper = "0.0.71"
        val expect = "0.0.30"
    }
}

kotlin {
    jvm { library() }
    js(IR) { library() }
    val darwinTargets = listOf(
        watchosArm64(),
        watchosArm32(),
        watchosX86(),
        macosX64(),
        iosArm64(),
        iosArm32(),
        iosX64(),
        tvosArm64(),
        tvosX64()
    )

    val linuxTargets = listOf(
        linuxArm32Hfp(),
        linuxArm64(),
        linuxX64()
    )
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:${vers.kotlinx.serialization}")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("expect-core", vers.asoft.expect))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.mapper,
    description = "A Kotlinx Serialization Extension for mapping between json objects and kotlin maps"
)