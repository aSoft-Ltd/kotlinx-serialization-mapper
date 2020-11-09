import tz.co.asoft.toJson
import tz.co.asoft.toJsonElement
import tz.co.asoft.toJsonObject
import tz.co.asoft.toKotlinMap
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SerializationTest {

    @Test
    fun `should convert any to JsonElements well`() {
        val number: Int? = 42
        val jsonElement = number.toJsonElement()
        println(jsonElement)
        assertEquals(number, jsonElement.primitive.int)
    }

    @Test
    fun `should convert a map to a json`() {
        val map = mapOf(
            "name" to "Anderson",
            "age" to 26,
            "hobbies" to listOf(
                "coding", "music", "robotics"
            ),
            "skills" to mapOf(
                "coding" to listOf("kotlin", "java"),
                "management" to listOf("finance", "human resources", "projects")
            )
        )
        val json = map.toJson()
        println(json)
        assertTrue(json.contains("Anderson"))
    }

    @Test
    fun `should convert a normal class to a kotlin map`() {
        val p1 = Person()
        val map = p1.toKotlinMap(Person.serializer())
        assertEquals("testname", map["name"])
    }
}