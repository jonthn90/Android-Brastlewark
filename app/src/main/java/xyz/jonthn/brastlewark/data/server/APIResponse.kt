package xyz.jonthn.brastlewark.data.server

data class APIResponse(
    val Brastlewark : List<Brastlewark>
)

data class Brastlewark(
    val age: Int,
    val friends: List<String>,
    val hair_color: String,
    val height: Double,
    val id: Int,
    val name: String,
    val professions: List<String>,
    val thumbnail: String,
    val weight: Double
)