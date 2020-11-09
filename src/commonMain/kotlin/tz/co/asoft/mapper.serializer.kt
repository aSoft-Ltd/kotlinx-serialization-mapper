package tz.co.asoft

import kotlinx.serialization.json.*

fun Any?.toJsonElement(): JsonElement = when (this) {
    is Int -> JsonPrimitive(this)
    is Double -> JsonPrimitive(this)
    is Float -> JsonPrimitive(this)
    is String -> try {
        JsonPrimitive(toLong())
    } catch (c: Throwable) {
        JsonPrimitive(this)
    }
    is List<*> -> JsonArray(this.map { it.toJsonElement() })
    is Array<*> -> JsonArray(this.map { it.toJsonElement() })
    is Map<*, *> -> {
        val map = mutableMapOf<String, JsonElement>()
        for ((key, value) in this) {
            if (key is String) map[key] = value.toJsonElement()
        }
        JsonObject(map)
    }
    else -> JsonNull
}

fun Map<String, *>.toJsonObject() = toJsonElement() as JsonObject

fun List<*>.toJsonObject() = toJsonElement() as JsonArray

fun Array<*>.toJsonObject() = toJsonElement() as JsonArray

fun Map<String, *>.toJson(): String = Json.stringify(JsonObjectSerializer, toJsonObject())

fun List<*>.toJson(): String = Json.stringify(JsonArraySerializer, toJsonObject())

fun Array<*>.toJson(): String = Json.stringify(JsonArraySerializer, toJsonObject())