# Test
![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

An Opinionated testing library for kotlin multiplatform
It supports
- Kotlin Multiplatform libraries
- Kotlin Javascript libraries
- Kotlin Android libraries
- Kotlin JVM libraries

## Introduction
Ever wanted to test suspending functions from common code without hack's? This is your spot

## Samples
In your testing code, you can do the following
```kotlin
    @Test
    @JsName("Test0") // If targeting javascript
    fun `should test a suspend function with no problem`() = asyncTest {
        delayForFun()
        // do suspending tasks here and perform assertions on the results
    }
```

## Setup:Gradle
Adding test as a dependency becomes as easy as just
### Kotlin Multiplatform
```kotlin
kotlin {
    // . . .
    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation("tz.co.asoft:test:+") // please use the latest version possible
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
        implementationTest("tz.co.asoft:test:+") // please use the latest version possible
        /* Or
         * You can be as specific as
         * tz.co.asoft:test-android:+
         * tz.co.asoft:test-js:+
         * tz.co.asoft:test-jvm:+
        */
        implementationTest("tz.co.asoft:test-android:+") // please use the latest version possible
    }
}
```
[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/test/1.0.1?style=flat
[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat
[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat
[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat
[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
