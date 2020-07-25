package xyz.jonthn.usescases

import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import xyz.jonthn.data.repository.InhabitantsRepository
import xyz.jonthn.domain.Inhabitant

@RunWith(MockitoJUnitRunner::class)
class FindInhabitantByIdTest {

    @Mock
    lateinit var inhabitantsRepository: InhabitantsRepository

    private lateinit var findInhabitantById: FindInhabitantById

    @Before
    fun setUp() {
        findInhabitantById = FindInhabitantById(inhabitantsRepository)
    }

    @Test
    fun `invoke calls repository`() {
        runBlocking {

            val inhabitant = mockedInhabitant.copy(id = 1)
            whenever(inhabitantsRepository.findById(1)).thenReturn(inhabitant)

            val result = findInhabitantById.invoke(1)

            assertEquals(inhabitant, result)
        }
    }

    private val mockedInhabitant = Inhabitant(
        0,
        arrayListOf("a", "b", "c"),
        "Blue",
        3.1416,
        0,
        "Frederic",
        arrayListOf("x", "y", "z"),
        "example.com/image.png",
        5.0
    )
}