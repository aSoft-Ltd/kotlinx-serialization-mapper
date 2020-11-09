import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val name: String = "testname",
    val age: Int = 30,
    val hobbies: List<String> = listOf("music", "movies")
)