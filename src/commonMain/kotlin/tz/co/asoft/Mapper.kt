package tz.co.asoft

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonObject
import kotlin.jvm.JvmStatic

open class Mapper(internal val JSON: Json) {
    companion object Default : Mapper(JSON = Json { })

    fun decodeFromString(json: String) = WrappedMap(
        JSON.decodeFromString(JsonObject.serializer(), json).toKMap()
    )

    fun encodeToString(map: Map<String, Any>) = JSON.encodeToString(
        JsonObject.serializer(), map.toJsonObject()
    )
}

fun Mapper(from: Mapper = Mapper, builder: JsonBuilder.() -> Unit) = Mapper(JSON = Json(from.JSON, builder))