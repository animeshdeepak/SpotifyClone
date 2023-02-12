package com.example.spotifyclone.di

import android.app.Application
import com.example.data.di.module.NetworkModule
import com.example.data.di.module.RepoModule
import com.example.spotifyclone.SpotifyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(
    includes = [NetworkModule::class,
        RepoModule::class]
)
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApp(): Application {
        return SpotifyApplication.appInstance
    }
}