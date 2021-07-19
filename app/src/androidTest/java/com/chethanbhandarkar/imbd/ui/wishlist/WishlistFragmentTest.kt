package com.chethanbhandarkar.imbd.ui.wishlist

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.chethanbhandarkar.imbd.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WishlistFragmentTest {
	private lateinit var scenario: FragmentScenario<WishlistFragment>

	@Before
	fun setUp() {
		scenario = launchFragmentInContainer(themeResId = R.style.Theme_IMBd)
		scenario.moveToState(Lifecycle.State.STARTED)

	}

	@Test
	fun testComingSoon() {
		onView(withId(R.id.tv_wl_comingsoon)).check(matches(withText("Coming Soon")))

	}
}