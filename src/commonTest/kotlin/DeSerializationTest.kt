import kotlinx.serialization.json.Json
import tz.co.asoft.getList
import tz.co.asoft.getMap
import tz.co.asoft.parseKotlinMap
import kotlin.test.Test
import kotlin.test.assertEquals

class DeSerializationTest {

    val json =
        """{"name":"Anderson","age":26,"hobbies":["coding","music","robotics"],"skills":{"coding":["kotlin","java"],"management":["finance","human resources","projects"]}}"""

    @Test
    fun `should convert a json to map`() {
        val map = Json.parseKotlinMap(json)
        assertEquals("Anderson", map["name"].toString())
    }

    @Test
    fun `should deserialize deep nesting`() {
        val map = Json.parseKotlinMap(json)
        val hobbies = map.getList("hobbies")
        assertEquals("coding", hobbies[0])
        assertEquals("music", hobbies[1])
        assertEquals("robotics", hobbies[2])

        val skills = map.getMap("skills")
        val codingSkills = skills.getList("coding")
        assertEquals("kotlin", codingSkills[0])
        assertEquals("java", codingSkills[1])
    }
}