package xyz.jonthn.data.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import xyz.jonthn.data.source.LocalDataSource
import xyz.jonthn.data.source.RemoteDataSource
import xyz.jonthn.domain.Inhabitant

@RunWith(MockitoJUnitRunner::class)
class InhabitantsRepositoryTest {


    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var inhabitantsRepository: InhabitantsRepository

    @Before
    fun setUp() {
        inhabitantsRepository =
            InhabitantsRepository(localDataSource, remoteDataSource)
    }

    @Test
    fun `gets from local data source first`() {
        runBlocking {

            val local = listOf(mockedInhabitant.copy(1))
            whenever(localDataSource.isEmpty()).thenReturn(false)
            whenever(localDataSource.getInhabitants()).thenReturn(local)

            val result = inhabitantsRepository.getInhabitants()

            assertEquals(local, result)
        }
    }

    @Test
    fun `saves remote data to local`() {
        runBlocking {

            val remote= listOf(mockedInhabitant.copy(2))
            whenever(localDataSource.isEmpty()).thenReturn(true)
            whenever(remoteDataSource.getInhabitants()).thenReturn(remote)

            inhabitantsRepository.getInhabitants()

            verify(localDataSource).saveInhabitants(remote)
        }
    }

    @Test
    fun `findById calls local data source`() {
        runBlocking {

            val inhabitant = mockedInhabitant.copy(id = 5)
            whenever(localDataSource.findById(5)).thenReturn(inhabitant)

            val result = inhabitantsRepository.findById(5)

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