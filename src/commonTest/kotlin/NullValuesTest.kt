import tz.co.asoft.Mapper
import kotlin.test.Test

class NullValuesTest {
    @Test
    fun should_fail_miserably() {
        val map = mapOf(
            "test" to true,
            "names" to listOf("test1", "test2"),
            "map" to mapOf(
                "people" to null,
                "enjoyment" to 4
            ),
            "id" to 1
        )

        val json = Mapper.encodeToString(map)
        println(json)
    }
}