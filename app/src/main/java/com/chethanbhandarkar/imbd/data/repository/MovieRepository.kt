package com.chethanbhandarkar.imbd.data.repository


import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData

import com.chethanbhandarkar.imbd.data.repository.pagination.IMBdPagingSource
import com.chethanbhandarkar.imbd.data.repository.remote.MovieApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApiService: MovieApiService):MovieRepositoryInterface {
	override fun getSearchResults(query: String?) =
		Pager(
			config = PagingConfig(
				pageSize = 10,
				maxSize = 100,
				enablePlaceholders = false,
				initialLoadSize = 10
			),
			pagingSourceFactory = {
				IMBdPagingSource(movieApiService,query)
			}
		).liveData

	override suspend fun getMovieDetails(imdbId: String?): LiveData<MoviesDetailsData> {
		TODO("Not yet implemented")
	}

}