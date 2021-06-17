import expect.expect
import expect.toBe
import kotlinx.serialization.mapper.Mapper
import kotlin.test.Test
import kotlin.test.expect

class MapperListTest {
    @Test
    fun should_encode_a_list_of_map_to_string() {
        val data = listOf(
            mapOf("name" to "john"),
            mapOf("name" to "jane")
        )
        val json = Mapper.encodeToString(data)
        expect(json).toBe("""[{"name":"john"},{"name":"jane"}]""")
    }

    @Test
    fun should_encode_a_list_of_map() {
        val json = """[{"name":"john"},{"name":"jane"}]"""
        val list = Mapper.decodeListFromString(json)
        expect(list.size).toBe(2)
        expect(list.first()["name"]).toBe("john")
    }
}