import tz.co.asoft.Mapper
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals

class MapToJsonTest {
    @Test
    fun should_decode_a_map_into_a_json() {
        val ogMap = mapOf(
            "name" to "John Doe",
            "age" to 34,
            "children" to mapOf(
                "name" to "Jane Doe",
                "age" to 14
            )
        )

        val json = Mapper.encodeToString(ogMap)
        println(json)

        val map = Mapper.decodeFromString(json)
        val name: String by map
        val age: Int by map

        assertEquals("John Doe", name)
        assertEquals(34, age)
    }
}