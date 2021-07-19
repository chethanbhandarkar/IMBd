package com.chethanbhandarkar.imbd.data.repository.remote


import com.chethanbhandarkar.imbd.BuildConfig
import com.chethanbhandarkar.imbd.data.repository.MoviesDataList
import com.chethanbhandarkar.imbd.data.repository.MoviesDetailsData
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
	companion object {
		const val BASE_URL = "https://www.omdbapi.com/"
		const val OMDB_ID = BuildConfig.OMDB_API_KEY
	}

	@GET(".")
	suspend fun getMovieListSearch(
		@Query("page") page: Int,
		@Query("s") query: String,
	   @Query("pageSize") pageSize: Int=10,
		@Query("apikey") apikey: String = OMDB_ID
	): MoviesDataList

	@GET(".")
	suspend fun getMovieDetails(

		@Query("apiKey") apiKey: String = OMDB_ID,
		@Query("i") imdbtitle: String,
	): MoviesDetailsData
}