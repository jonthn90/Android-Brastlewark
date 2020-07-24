package xyz.jonthn.usescases

import xyz.jonthn.data.repository.InhabitantsRepository
import xyz.jonthn.domain.Inhabitant

class GetInhabitants (private val inhabitantsRepository: InhabitantsRepository) {
    suspend fun invoke(): List<Inhabitant> = inhabitantsRepository.getInhabitants()
}
