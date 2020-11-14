import tz.co.asoft.Mapper
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals

class JsonToMapTest {
    @Test
    @JsName("test0")
    fun `should parse a json to a map`() {
        val json = """
            {
                "name": "John Doe",
                "age": 23,
                "isYoung": true
            }
        """.trimIndent()

        val map = Mapper.decodeFromString(json)
        assertEquals("John Doe", map["name"])
        assertEquals("23", map["age"])
        assertEquals("true", map["isYoung"])
    }

    @Test
    @JsName("test1")
    fun `should parse a nested json to a nested map`() {
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