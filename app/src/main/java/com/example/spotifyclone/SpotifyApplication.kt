package com.example.spotifyclone

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpotifyApplication : Application() {
    companion object {
        lateinit var appInstance: SpotifyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}