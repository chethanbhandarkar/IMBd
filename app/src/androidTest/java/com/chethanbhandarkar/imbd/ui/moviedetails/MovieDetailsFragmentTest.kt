package com.chethanbhandarkar.imbd.ui.moviedetails


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chethanbhandarkar.imbd.launchFragmentInHiltContainer
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)

class MovieDetailsFragmentTest {

	//@get:Rule
	//var hiltRule = HiltAndroidRule(this)


	@get:Rule
	var instantTaskExecutorRule = InstantTaskExecutorRule()
	@Before
	fun setUp() {
		//hiltRule.inject()

	}



	@Test
	fun checkLoaded(){
		launchFragmentInHiltContainer<MovieDetailsFragment> {

		}






	}
}