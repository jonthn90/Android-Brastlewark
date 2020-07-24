package xyz.jonthn.brastlewark.data.database

import androidx.room.*

@Dao
interface InhabitantDAO {

    @Query("SELECT * FROM Inhabitant")
    fun getAll(): List<Inhabitant>

    @Query("SELECT * FROM Inhabitant WHERE id = :id")
    fun findById(id: Int): Inhabitant

    @Query("SELECT COUNT(id) FROM Inhabitant")
    fun inhabitantsCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertInhabitants(movies: List<Inhabitant>)

    @Query("SELECT * FROM Inhabitant WHERE name LIKE '%' || :search || '%'")
    fun searchByName(search: String?): List<Inhabitant>
}