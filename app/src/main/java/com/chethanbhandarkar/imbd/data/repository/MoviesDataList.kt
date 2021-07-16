package com.chethanbhandarkar.imbd.data.repository

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesDataList(


	@SerializedName("Response")
	var response: String,

	@SerializedName("Search")
	var search: List<MoviesHomeData>?

):Parcelable{

	@Parcelize
	data class MoviesHomeData(
	//{"Search":[{"Title":"Lagaan: Once Upon a Time in India","Year":"2001","imdbID":"tt0169102","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDYxNWUzZmYtOGQxMC00MTdkLTkxOTctYzkyOGIwNWQxZjhmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg"},{"Title":"Chak De! India","Year":"2007","imdbID":"tt0871510","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTUzODMyNzk4NV5BMl5BanBnXkFtZTgwNTk1NTYyNTM@._V1_SX300.jpg"},{"Title":"A Passage to India","Year":"1984","imdbID":"tt0087892","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNzc0M2EwNWMtZDc1Zi00OGE2LThmMDItNTY5MDQ5ZDQ3ZTBmXkEyXkFqcGdeQXVyMTAwMzUyOTc@._V1_SX300.jpg"},{"Title":"Mr. India","Year":"1987","imdbID":"tt0093578","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BZTdhMmJjYjMtMjZmOC00NjhkLWE3MjQtODAzNDI4NmM5OTA5XkEyXkFqcGdeQXVyODAzNzAwOTU@._V1_SX300.jpg"},{"Title":"Mother India","Year":"1957","imdbID":"tt0050188","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNDcyMDE0ZWUtYjI3Ny00N2U2LWEzMTAtYzE4OTEzZjgyNzQ1XkEyXkFqcGdeQXVyNjQ1MDcxNzM@._V1_SX300.jpg"},{"Title":"Naa Peru Surya Na Illu India","Year":"2018","imdbID":"tt7794524","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BYjJlNzcxYmItOTA1Zi00ZjdkLWJhNDgtODNkOTE3N2E1NzU2XkEyXkFqcGdeQXVyNTgxODY5ODI@._V1_SX300.jpg"},{"Title":"Bad Boy Billionaires: India","Year":"2020–","imdbID":"tt12923630","Type":"series","Poster":"https://m.media-amazon.com/images/M/MV5BYThmNjc4YTktMWYwMS00NmRmLTk0MzQtODBlMWU3NmRiMjRhXkEyXkFqcGdeQXVyNjEwNTM2Mzc@._V1_SX300.jpg"},{"Title":"Why Cheat India","Year":"2019","imdbID":"tt8108208","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BNjkyYmYzZGEtYzkwZS00ODk0LThhYmItODg1ZThjYzFkNTZiXkEyXkFqcGdeQXVyMjUxMTY3ODM@._V1_SX300.jpg"},{"Title":"India Song","Year":"1975","imdbID":"tt0073166","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BYzJkYmQ3ZTQtYmMwZS00YTdjLTkwMTEtYTQ5NzcxMjA0ZjkwXkEyXkFqcGdeQXVyNjY5MDUyMjE@._V1_SX300.jpg"},{"Title":"The Dead 2: India","Year":"2013","imdbID":"tt2917336","Type":"movie","Poster":"https://m.media-amazon.com/images/M/MV5BMTkxNDIxMTYxNl5BMl5B
		@SerializedName("Title")
		var Title: String,

		@SerializedName("Year")
		var Year: String,

		@SerializedName("imdbID")
		var imdbID:String,

		@SerializedName("Type")
		var Type: String,

		@SerializedName("Poster")
		var Poster: String,



	):Parcelable






}





