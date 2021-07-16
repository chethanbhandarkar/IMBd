package com.chethanbhandarkar.imbd.ui.moviedetails


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chethanbhandarkar.imbd.data.repository.MovieRepository
import com.chethanbhandarkar.imbd.data.repository.MoviesDetailsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

	private val _currentMovie = MutableLiveData<MoviesDetailsData>()
	val currentMovie: LiveData<MoviesDetailsData>
		get()=_currentMovie


	fun getMovieDetail(imdbTitle:String) {
		viewModelScope.launch {
			_currentMovie.value=repository.getMovieDetails(imdbId = imdbTitle)
		}
	}

}