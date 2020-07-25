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
class GetInhabitantsTest {


    @Mock
    lateinit var inhabitantsRepository: InhabitantsRepository

    private lateinit var getInhabitants: GetInhabitants

    @Before
    fun setUp() {
        getInhabitants = GetInhabitants(inhabitantsRepository)
    }

    @Test
    fun `invoke calls repository`() {
        runBlocking {

            val inhabitants = listOf(mockedInhabitant.copy(id = 1))
            whenever(inhabitantsRepository.getInhabitants()).thenReturn(inhabitants)

            val result = getInhabitants.invoke()

            assertEquals(inhabitants, result)
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