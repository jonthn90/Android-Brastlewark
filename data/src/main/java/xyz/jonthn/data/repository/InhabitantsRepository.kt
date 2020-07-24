package xyz.jonthn.data.repository

import xyz.jonthn.data.source.LocalDataSource
import xyz.jonthn.data.source.RemoteDataSource
import xyz.jonthn.domain.Inhabitant

class InhabitantsRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getInhabitants(): List<Inhabitant> {

        if (localDataSource.isEmpty()) {
            val inhabitants = remoteDataSource.getInhabitants()
            localDataSource.saveInhabitants(inhabitants)
            println("empty")
        } else {
            println("not empty")
        }
        return localDataSource.getInhabitants()
    }

    suspend fun findById(id: Int): Inhabitant = localDataSource.findById(id)

    suspend fun searchByName(name: String): List<Inhabitant> = localDataSource.searchByName(name)

}