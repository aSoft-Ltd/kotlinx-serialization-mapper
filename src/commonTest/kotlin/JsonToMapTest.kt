import kotlinx.serialization.mapper.Mapper
import kotlin.test.Test
import kotlin.test.assertEquals

class JsonToMapTest {
    @Test
    fun should_parse_a_json_to_a_map() {
        val json = """
            {
                "name": "John Doe",
                "age": 23,
                "isYoung": true,
                "weight": "23"
            }
        """.trimIndent()

        val map = Mapper.decodeFromString(json)
        assertEquals("John Doe", map["name"])
        assertEquals(23, map["age"])
        assertEquals(true, map["isYoung"])
        assertEquals("23", map["weight"])
    }

    @Test
    fun should_parse_a_nested_json_to_a_nested_map() {
        val json = """
            {
                "name": "John Doe",
                "age": 23,
                "isYoung": true,
                "children": [
                    {
                        "name": "Child One"
                    },
                    {
                        "name": "Child Two"
                    }
                ]
            }
        """.trimIndent()

        val map = Mapper.decodeFromString(json)
        val name: String by map
        val age: Int by map
        val isYoung: Boolean by map
        assertEquals("John Doe", name)
        assertEquals(23, age)
        assertEquals(true, isYoung)

        val children: List<Map<String, Any>> by map

        assertEquals("Child One", children[0]["name"])
    }
}