package xyz.jonthn.brastlewark.data.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import xyz.jonthn.brastlewark.data.toDomainInhabitant
import xyz.jonthn.brastlewark.data.toRoomInhabitant
import xyz.jonthn.data.source.LocalDataSource
import xyz.jonthn.domain.Inhabitant

class RoomDataSource(db: InhabitantDatabase) : LocalDataSource {

    private val inhabitantDAO = db.inhabitantDAO()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { inhabitantDAO.inhabitantsCount() <= 0 }

    override suspend fun saveInhabitants(inhabitants: List<Inhabitant>) {
        withContext(Dispatchers.IO) { inhabitantDAO.insertInhabitants(inhabitants.map { it.toRoomInhabitant() }) }
    }

    override suspend fun getInhabitants(): List<Inhabitant> = withContext(Dispatchers.IO) {
        inhabitantDAO.getAll().map { it.toDomainInhabitant() }
    }

    override suspend fun findById(id: Int): Inhabitant = withContext(Dispatchers.IO) {
        inhabitantDAO.findById(id).toDomainInhabitant()
    }

}
