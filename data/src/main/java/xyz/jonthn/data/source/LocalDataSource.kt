package xyz.jonthn.data.source

import xyz.jonthn.domain.Inhabitant

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveInhabitants(inhabitants: List<Inhabitant>)
    suspend fun getInhabitants(): List<Inhabitant>
    suspend fun findById(id: Int): Inhabitant
}