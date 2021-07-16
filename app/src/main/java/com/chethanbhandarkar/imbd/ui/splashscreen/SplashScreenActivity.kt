package com.chethanbhandarkar.imbd.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.chethanbhandarkar.imbd.MainActivity
import com.chethanbhandarkar.imbd.R

class SplashScreenActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash_screen)

		Handler(Looper.getMainLooper()).postDelayed(
			{
				val intent = Intent(this, MainActivity::class.java)
				startActivity(intent)
				finish()
			}, 1000
		)

	}
}