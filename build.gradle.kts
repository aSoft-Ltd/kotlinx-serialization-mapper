plugins {
    id("com.android.library") version "4.1.0"
    kotlin("multiplatform") version "1.4.21"
    id("tz.co.asoft.library") version "1.2.0"
    id("io.codearte.nexus-staging") version "0.22.0"
    signing
}

object vers {
    object kotlinx {
        val serialization = "1.0.1"
    }
    object asoft {
        val mapper = "0.0.4"
        val test = "1.0.1"
    }
}

kotlin {
    universalLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:${vers.kotlinx.serialization}")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(asoft("test", vers.asoft.test))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.mapper,
    description = "A Kotlinx Serialization Extension for mapping between json objects and kotlin maps"
)