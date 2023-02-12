package com.example.data.di.module

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import com.example.data.repositoryImpl.SharedPrefRepositoryImpl
import com.example.domain.repository.PrefRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefModule {

    private const val PREF_NAME = "SPOTIFY_APPLICATION"

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideEditor(pref: SharedPreferences): Editor = pref.edit()

    @Provides
    @Singleton
    fun providePrefRepo(pref: SharedPreferences, editor: Editor): PrefRepository =
        SharedPrefRepositoryImpl(pref, editor)
}