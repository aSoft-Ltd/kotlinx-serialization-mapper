package tz.co.asoft

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

object Mapper {
    fun decodeFromString(json: String) = WrappedMap(
        Json.decodeFromString(JsonObject.serializer(), json).toKMap()
    )

    fun encodeToString(map: Map<String, Any>) = Json.encodeToString(
        JsonObject.serializer(), map.toJsonObject()
    )
}