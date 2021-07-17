package com.chethanbhandarkar.imbd

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.chethanbhandarkar.imbd.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val navView: BottomNavigationView = binding.navView
		val navController = findNavController(R.id.nav_host_fragment_activity_main)
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		navView.setupWithNavController(navController)

		navController.addOnDestinationChangedListener { _, destination, _ ->
			when(destination.id)
			{
				R.id.moviedetailsFragment->navView.visibility= View.GONE
				R.id.navigation_home->navView.visibility= View.VISIBLE
			//	R.id.webviewFragment->navView.visibility= View.GONE
				else->navView.visibility= View.VISIBLE
			}
		}

	}
}