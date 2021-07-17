package com.chethanbhandarkar.imbd.ui.home

import android.graphics.Movie
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.chethanbhandarkar.imbd.data.repository.MovieRepository
import com.chethanbhandarkar.imbd.data.repository.MoviesDetailsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
	private val currentQuery = MutableLiveData(DEFAULT_QUERY)

	val movies = currentQuery.switchMap { queryString ->
		repository.getSearchResults(queryString).cachedIn(viewModelScope)
	}

	fun getTopHeadlines(query: String?) {
		currentQuery.value = query

	}

	companion object {
		private val DEFAULT_QUERY: String? = null
		//private val DEFAULT_MOVIE: String? = null
	//	private val CURRENT_QUERY: String = "current_query"

	}
}