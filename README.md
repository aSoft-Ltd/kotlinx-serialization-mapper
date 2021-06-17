# Kotlinx Serialization Mapper

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

## Introduction

Built on top of the famous `kotlinx-serialization-json`, this library helps to serialize between json maps and kotlin
maps.

## Samples

Getting an map from a json

```kotlin
val json = """
{
    "environment": "production",
    "logging": "warnings",
    "key": "SOME_TEST_KEY",
    "bool": true,
    "integer": 43,
    "double": 46.55
}
""".trimIndent()

val map = Mapper.decodeFromString(json)

val environment: String by map
val logging: String by map
val key: String by map
val bool: Boolean by map
val integer: Int by map
val double: Double by map
```

## Setup:Gradle

Adding `kotlinx-serialization-mapper` as a dependency becomes as easy as just

### Kotlin Multiplatform

```kotlin
kotlin {
    // . . .
    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation("tz.co.asoft:kotlinx-serialization-mapper:0.0.71") // please use the latest version possible
            }
        }
    }
}
```

### Kotlin [android|jvm|js]

```kotlin
kotlin {
    // . . .
    dependencies {
        implementationTest("tz.co.asoft:kotlinx-serialization-mapper:0.0.71")
    }
}
```

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/kotlinx-serialization-mapper/0.0.71?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
