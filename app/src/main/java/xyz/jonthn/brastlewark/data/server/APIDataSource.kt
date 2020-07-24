package xyz.jonthn.brastlewark.data.server

import xyz.jonthn.brastlewark.data.toDomainInhabitant
import xyz.jonthn.data.source.RemoteDataSource
import xyz.jonthn.domain.Inhabitant

class APIDataSource : RemoteDataSource {

    override suspend fun getInhabitants(): List<Inhabitant> =
        API.service
            .getInhabitants()
            .Brastlewark
            .map { it.toDomainInhabitant() }
}