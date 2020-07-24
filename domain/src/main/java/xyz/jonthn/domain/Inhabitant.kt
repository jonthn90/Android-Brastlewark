package xyz.jonthn.domain

data class Inhabitant(
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