package com.rezyfr.dicoding.made.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rezyfr.dicoding.core.data.source.repository.MovieRepository
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.domain.usecase.MovieInteractor
import com.rezyfr.dicoding.core.utils.formatToHourMinutes
import com.rezyfr.dicoding.core.utils.formatToK
import com.rezyfr.dicoding.made.ui.detail.DetailViewModel
import com.rezyfr.dicoding.made.utils.CoroutineTestRule
import com.rezyfr.dicoding.made.utils.MovieItemDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotSame
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class DetailViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()
    private var viewModel: DetailViewModel? = null
    private var repo = mock(MovieRepository::class.java)

    val movie = MutableLiveData<Movie>()
    val detail = MovieItemDummy.getMovieDetail()

    @Before
    fun setUp() {
        viewModel = DetailViewModel(MovieInteractor(repo))
        movie.value = Movie(
            detail.overview,
            detail.originalLanguage,
            detail.title,
            detail.posterPath,
            detail.backdropPath,
            detail.releaseDate,
            detail.voteAverage,
            detail.id,
            detail.voteCount?.formatToK(),
            detail.runtime?.formatToHourMinutes()
        )
    }

    @Test
    fun getMovieDetail() = coroutinesTestRule.testDispatcher.runBlockingTest {
        `when`(repo.getMovieDetail(detail.id!!)).thenReturn(flowOf(movie.value!!))
        val observer = mock(Observer::class.java)
        viewModel?.getMovieDetail(detail.id!!)
        viewModel?.movieDetail?.observeForever(observer as Observer<Movie>)

        assertEquals(movie.value!!.id, viewModel?.movieDetail?.value?.id )
        assertEquals(movie.value!!.overview, viewModel?.movieDetail?.value?.overview )
        assertEquals(movie.value!!.title, viewModel?.movieDetail?.value?.title )
    }

    @Test
    fun getWrongMovieDetail() = coroutinesTestRule.testDispatcher.runBlockingTest {
        `when`(repo.getMovieDetail(detail.id!!)).thenReturn(flowOf(movie.value!!))
        val observer = mock(Observer::class.java)
        viewModel?.getMovieDetail(0)
        viewModel?.movieDetail?.observeForever(observer as Observer<Movie>)

        assertNotSame(movie.value!!.id, viewModel?.movieDetail?.value?.id )
        assertNotSame(movie.value!!.overview, viewModel?.movieDetail?.value?.overview )
        assertNotSame(movie.value!!.title, viewModel?.movieDetail?.value?.title )
    }
}