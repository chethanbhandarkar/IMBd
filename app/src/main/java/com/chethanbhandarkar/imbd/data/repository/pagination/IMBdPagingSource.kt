package com.chethanbhandarkar.imbd.data.repository.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.chethanbhandarkar.imbd.data.repository.MoviesDataList
import com.chethanbhandarkar.imbd.data.repository.remote.MovieApiService
import retrofit2.HttpException
import java.io.IOException
private const val STARTING_PAGE_INDEX = 1

class IMBdPagingSource (
	private val movieApiService: MovieApiService,
	private val query: String? = null
) : PagingSource<Int, MoviesDataList.MoviesHomeData>() {
	val list= listOf<MoviesDataList.MoviesHomeData>()

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int,MoviesDataList.MoviesHomeData> {
		val pagePosition = params.key ?: STARTING_PAGE_INDEX

		return try {
			val queryResponse: MoviesDataList = if (query.isNullOrEmpty()) {
				movieApiService.getMovieListSearch(
					page = pagePosition,
					pageSize = params.loadSize,
					query = "America"
				)

			} else {
				movieApiService.getMovieListSearch(
					page = pagePosition,
					pageSize = params.loadSize,
					query = query
				)
			}


			LoadResult.Page(

						data=queryResponse.search?:list,
						prevKey= if (pagePosition == STARTING_PAGE_INDEX) null else pagePosition - 1,
						nextKey = if (queryResponse.search.isNullOrEmpty()) null else pagePosition + 1


			)

		} catch (exception: IOException) {
			LoadResult.Error(exception)
			//Resource.error("Input Output Exception",null)

		} catch (exception: HttpException) {
			LoadResult.Error(exception)

		}

	}

	override fun getRefreshKey(state: PagingState<Int, MoviesDataList.MoviesHomeData>): Int? {
		return null
	}

}