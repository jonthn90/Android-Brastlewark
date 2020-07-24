package xyz.jonthn.data.repository

import xyz.jonthn.data.source.RemoteDataSource
import xyz.jonthn.domain.Inhabitant

class InhabitantsRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getInhabitants() : List<Inhabitant>{
        return remoteDataSource.getInhabitants()
    }
}