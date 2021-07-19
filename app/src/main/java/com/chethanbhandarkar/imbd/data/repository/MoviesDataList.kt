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
) : Parcelable {
	@Parcelize
	data class MoviesHomeData(
		@SerializedName("Title")
		var Title: String,
		@SerializedName("Year")
		var Year: String,
		@SerializedName("imdbID")
		var imdbID: String,
		@SerializedName("Type")
		var Type: String,
		@SerializedName("Poster")
		var Poster: String,
		) : Parcelable
}





