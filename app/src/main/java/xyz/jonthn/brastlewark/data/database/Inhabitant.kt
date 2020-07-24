package xyz.jonthn.brastlewark.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Inhabitant(
    @PrimaryKey val id: Int,
    val age: Int,
    val friends: List<String>,
    val hair_color: String,
    val height: Double,
    val name: String,
    val professions: List<String>,
    val thumbnail: String,
    val weight: Double
)