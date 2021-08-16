package com.rezyfr.dicoding.core.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rezyfr.dicoding.core.data.source.remote.network.TmdbService
import com.rezyfr.dicoding.core.data.source.remote.response.MovieDetailResponse
import com.rezyfr.dicoding.core.domain.model.Movie
import com.rezyfr.dicoding.core.utils.MappingHelper
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val service: TmdbService
) : PagingSource<Int, Movie>() {

    private val firstPage = 1
    var query: String = ""

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val page = params.key ?: firstPage
            val movieList = if (query.isNotEmpty()) service.searchMovie(query)
            else service.discoverMovie(page)

            val data = movieList.results?.let { MappingHelper.mapMovieResponseToDomain(it) }

            val prevPage = if (page == firstPage) null
            else page - 1

            val nextPage = if (data?.isEmpty() == true) null
            else page + 1

            LoadResult.Page(
                data.orEmpty(),
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    suspend fun fetchMovieDetail(movieId: Int): MovieDetailResponse {
        return service.getMovieDetail(movieId)
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}