package com.chethanbhandarkar.imbd.di


import com.chethanbhandarkar.imbd.data.repository.remote.MovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun provideRetrofit(): Retrofit =
		Retrofit.Builder()
			.baseUrl(MovieApiService.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()

	@Provides
	@Singleton
	fun provideMovieApiService(retrofit: Retrofit): MovieApiService =
		retrofit.create(MovieApiService::class.java)
}