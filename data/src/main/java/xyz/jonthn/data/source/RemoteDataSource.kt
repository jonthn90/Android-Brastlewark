package xyz.jonthn.data.source

import xyz.jonthn.domain.Inhabitant

interface RemoteDataSource {
    suspend fun getInhabitants(): List<Inhabitant>
}