package com.rezyfr.dicoding.made.data.repository

import com.rezyfr.dicoding.core.data.source.local.LocalDataSource
import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.core.data.source.remote.NowPlayingDataSource
import com.rezyfr.dicoding.core.data.source.remote.PopularDataSource
import com.rezyfr.dicoding.core.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.made.utils.CoroutineTestRule
import com.rezyfr.dicoding.made.utils.MovieItemDummy
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class AcademyRepositoryTest {

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    private val popularDataSource = Mockito.mock(PopularDataSource::class.java)
    private val nowPlayingDataSource = Mockito.mock(NowPlayingDataSource::class.java)
    private val remoteDataSource = Mockito.mock(RemoteDataSource::class.java)
    private val localDataSource = Mockito.mock(LocalDataSource::class.java)
    private val repo = FakeMovieRepository(
        popularDataSource,
        nowPlayingDataSource,
        remoteDataSource,
        localDataSource
    )

    @Test
    fun getMovieList() = runBlocking {
        val dataReceived = repo.discoverNowPlayingMovies()
        assertNotNull(dataReceived)
    }

    @Test
    fun getAllCourses() = runBlocking {
        val movie = MovieItemDummy.getMovieListResponse().map {
            MovieEntity(
                id = it.id,
                title = it.title,
                backdropPath = it.backdropPath,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage?.div(2),
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                overview = it.overview
            )
        }
        `when`(localDataSource.getFavoriteMovies()).thenReturn(flowOf(movie))
        localDataSource.getFavoriteMovies().collect {
            assertEquals(movie.size, it.size)
        }
    }
}