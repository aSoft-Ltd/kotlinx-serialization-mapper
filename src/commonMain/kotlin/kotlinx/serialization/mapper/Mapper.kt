package kotlinx.serialization.mapper

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonObject

open class Mapper(internal val JSON: Json) {
    companion object Default : Mapper(JSON = Json { })

    fun decodeFromString(json: String) = WrappedMap(
        JSON.decodeFromString(JsonObject.serializer(), json).toKMap()
    )

    fun encodeToString(map: Map<String, *>) = JSON.encodeToString(
        JsonObject.serializer(), map.toJsonObject()
    )

    fun encodeToString(list: List<Map<String, *>>) = list.joinToString(
        separator = ",", prefix = "[", postfix = "]"
    ) { encodeToString(it) }

    fun decodeListFromString(json: String): List<Map<String, *>> {
        val raw = """{"data":$json}"""
        val data: List<Map<String, *>> by decodeFromString(raw)
        return data
    }
}

fun Mapper(from: Mapper = Mapper, builder: JsonBuilder.() -> Unit) = Mapper(JSON = Json(from.JSON, builder))