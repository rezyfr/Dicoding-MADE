package com.rezyfr.dicoding.made.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rezyfr.dicoding.core.data.source.repository.MovieRepository
import com.rezyfr.dicoding.core.domain.usecase.MovieInteractor
import com.rezyfr.dicoding.made.ui.home.HomeViewModel
import com.rezyfr.dicoding.made.utils.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()
    private var viewModel: HomeViewModel? = null
    private var useCase = Mockito.mock(MovieInteractor::class.java)
    private var repo = Mockito.mock(MovieRepository::class.java)

//    @Before
//    fun setUp() {
//        viewModel = HomeViewModel(useCase)
//    }

//    @Test
//    fun getMovieList() {
//        val movie = MutableLiveData<List<Movie>>()
//        movie.value = MovieItemDummy.getMovieListResponse().results?.map {
//            Movie(
//                it.overview,
//                it.originalLanguage,
//                it.title,
//                it.posterPath,
//                it.backdropPath,
//                it.releaseDate,
//                it.voteAverage,
//                it.id,
//                it.voteCount?.formatToK(),
//                null
//            )
//        }
//        `when`(repo.discoverPopularMovies()).thenReturn(flowOf(PagingData.from(movie.value!!)))
//        val observer = Mockito.mock(Observer::class.java)
//        viewModel?.popularMovies?.observeForever(observer as Observer<PagingData<Movie>>)
//        verify(repo).discoverPopularMovies()
//    }

//    @Test
//    fun getWrongMovieList() {
//        val movie = MutableLiveData<List<MovieEntity>>()
//        movie.value = MovieItemDummy.getMovieListResponse().results?.map {
//            MovieEntity(
//                it.id,
//                it.title,
//                it.overview,
//                it.posterPath,
//                it.releaseDate
//            )
//        }
//        `when`(data.getMovieList()).thenReturn(movie)
//        val observer = Mockito.mock(Observer::class.java)
//        viewModel?.movieList()?.observeForever(observer as Observer<List<MovieEntity>>)
//        verify(data).getMovieList()
//        assertNotSame(movie.value, viewModel?.tvList()?.value)
//    }
}