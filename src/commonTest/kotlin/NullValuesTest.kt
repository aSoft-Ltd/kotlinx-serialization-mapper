import tz.co.asoft.Mapper
import kotlin.test.Test
import kotlin.test.assertEquals

class NullValuesTest {
    @Test
    fun should_encode_null() {
        val map = mapOf(
            "test" to true,
            "again" to null,
            "names" to listOf("test1", "test2"),
            "map" to mapOf(
                "people" to null,
                "enjoyment" to 4
            ),
            "id" to 1
        )

        val json = Mapper.encodeToString(map)
        assertEquals("""{"test":true,"again":null,"names":["test1","test2"],"map":{"people":null,"enjoyment":4},"id":1}""", json)
    }

    @Test
    fun should_decode_nulls_too() {
        val json = """{"test":true,"again":null,"names":["test1","test2"],"map":{"people":null,"enjoyment":4},"id":1}"""
        val map = Mapper.decodeFromString(json)
        assertEquals(null, map["admin"])
    }
}