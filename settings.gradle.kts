pluginManagement {
    repositories {
        google()
        jcenter()
    }
}

rootProject.name = "mapper"
listOf("../../build-src/code").mapNotNull {
    file(it).takeIf { file -> file.exists() }
}.forEach {
    includeBuild(it.relativeTo(file(".")))
}

//includeBuild("../test")