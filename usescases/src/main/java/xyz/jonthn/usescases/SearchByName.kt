package xyz.jonthn.usescases

import xyz.jonthn.data.repository.InhabitantsRepository
import xyz.jonthn.domain.Inhabitant

class SearchByName (private val inhabitantsRepository: InhabitantsRepository) {
    suspend fun invoke(name: String): List<Inhabitant> = inhabitantsRepository.searchByName(name)
}