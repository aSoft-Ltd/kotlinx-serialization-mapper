plugins {
    id("com.android.library") version "4.1.0"
    kotlin("multiplatform") version "1.4.10"
    id("tz.co.asoft.library") version "0.0.7"
    id("io.codearte.nexus-staging") version "0.22.0"
    signing
}

object vers {
    object asoft {
        val mapper = "0.0.1"
        val test = "1.0.1"
    }
}

repositories {
    google()
    publicRepos()
}

kotlin {
    universalLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:${versions.kotlinx.serialization}")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("test", vers.asoft.test))
            }
        }
    }
}

aSoftLibrary(
    version = vers.asoft.mapper,
    description = "A Kotlinx Serialization Extension for mapping between json objects and kotlin maps"
)