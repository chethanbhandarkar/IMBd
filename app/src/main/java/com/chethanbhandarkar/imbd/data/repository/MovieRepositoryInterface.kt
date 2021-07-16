package com.chethanbhandarkar.imbd.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData

interface MovieRepositoryInterface {



	fun getSearchResults(query: String?): LiveData<PagingData<MoviesDataList.MoviesHomeData>>
	suspend fun getMovieDetails(imdbId:String):MoviesDetailsData


}