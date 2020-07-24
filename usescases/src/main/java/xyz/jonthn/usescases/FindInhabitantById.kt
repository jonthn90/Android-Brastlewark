package xyz.jonthn.usescases

import xyz.jonthn.data.repository.InhabitantsRepository
import xyz.jonthn.domain.Inhabitant

class FindInhabitantById(private val inhabitantsRepository: InhabitantsRepository) {
    suspend fun invoke(id: Int): Inhabitant = inhabitantsRepository.findById(id)
}