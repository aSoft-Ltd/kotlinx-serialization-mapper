package tz.co.asoft

import kotlinx.serialization.StringFormat
import kotlinx.serialization.json.*

fun String.toJsonObject(): JsonObject = Json.parse(JsonObjectSerializer, this)

fun JsonElement.toKObject(): Any? = when (this) {
    is JsonLiteral -> body
    JsonNull -> null
    is JsonObject -> content.mapValues { it.value.toKObject() }
    is JsonArray -> content.map { it.toKObject() }
}

fun JsonObject.toMap(): Map<String, Any> {
    val map = mutableMapOf<String, Any>()
    for ((k, v) in content) {
        v.toKObject()?.let { map[k] = it }
    }
    return map
}

fun StringFormat.parseKotlinMap(json: String): Map<String, Any> {
    val jsonObject = Json.parse(JsonObjectSerializer, json)
    return jsonObject.toMap()
}