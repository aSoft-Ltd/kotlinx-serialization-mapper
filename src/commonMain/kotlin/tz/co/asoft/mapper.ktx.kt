package tz.co.asoft

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

fun Map<String, Any?>.getMap(key: String) = this[key] as Map<String, Any?>

fun Map<String, Any?>.getList(key: String) = this[key] as List<Any?>

fun <T : Any> T.toKotlinMap(serializer: KSerializer<T>): Map<String, Any> {
    val json = Json.stringify(serializer, this)
    return Json.parseKotlinMap(json)
}