package com.rezyfr.dicoding.made.data.repository

import com.rezyfr.dicoding.core.data.source.local.LocalDataSource
import com.rezyfr.dicoding.core.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.core.data.source.remote.PopularDataSource
import com.rezyfr.dicoding.core.data.source.remote.TopRatedDataSource
import com.rezyfr.dicoding.core.data.source.remote.RemoteDataSource
import com.rezyfr.dicoding.core.data.source.repository.MovieRepository
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

    private val upcomingDataSource = Mockito.mock(TopRatedDataSource::class.java)
    private val popularDataSource = Mockito.mock(PopularDataSource::class.java)
    private val remoteDataSource = Mockito.mock(RemoteDataSource::class.java)
    private val localDataSource = Mockito.mock(LocalDataSource::class.java)
    private val repo = MovieRepository(
        upcomingDataSource,
        popularDataSource,
        remoteDataSource,
        localDataSource
    )

    @Test
    fun getMovieList() = runBlocking {
        val dataReceived = repo.discoverPopularMovies()
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

    fun check(arr: IntArray, k: Int): Boolean {
        for (`val` in arr) {
            if (`val` != 0 && `val` != k) return false
        }
        return true
    }

    fun perfectSubstring(s: String, k: Int): Int {
        var res = 0
        for (i in 0 until s.length) {
            val arr = IntArray(10)
            for (j in i until s.length) {
                if (j > i + 10 * k) break
                val ch = s[j]
                arr[ch - '0']++
                if (check(arr, k)) res++
            }
        }
        return res
    }
}