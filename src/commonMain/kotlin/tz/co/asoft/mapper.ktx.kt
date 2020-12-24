package tz.co.asoft

import kotlinx.serialization.json.*
import kotlin.reflect.KProperty

internal fun JsonElement.toKObject(): Any? = when (this) {
    is JsonObject -> mapValues { it.value.toKObject() }
    is JsonArray -> map { it.toKObject() }
    JsonNull -> null
    is JsonPrimitive -> if (isString) {
        content
    } else {
        booleanOrNull ?: intOrNull ?: longOrNull ?: doubleOrNull
    }
}

internal fun JsonObject.toKMap(): Map<String, Any> {
    val map = mutableMapOf<String, Any>()
    for ((k, v) in this) v.toKObject()?.let { map[k] = it }
    return map
}

internal fun Any?.toJsonElement(): JsonElement = when (this) {
    null -> JsonNull
    is Number -> JsonPrimitive(this)
    is Boolean -> JsonPrimitive(this)
    is String -> JsonPrimitive(this)
    is Collection<*> -> JsonArray(mapNotNull { it.toJsonElement() })
    is Array<*> -> JsonArray(mapNotNull { it.toJsonElement() })
    is Map<*, *> -> JsonObject(map { (k, v) -> k.toString() to v.toJsonElement() }.toMap())
    else -> error("Failed to map $this to JsonElement")
}

internal fun Map<String, Any>.toJsonObject() = JsonObject(
    mapValues { (_, v) -> v.toJsonElement() }
)