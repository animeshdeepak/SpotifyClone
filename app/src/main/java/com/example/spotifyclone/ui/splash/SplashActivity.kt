package com.example.spotifyclone.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.spotifyclone.R
import com.example.spotifyclone.ui.HomeActivity

// todo remove warning
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 2000)
    }
}