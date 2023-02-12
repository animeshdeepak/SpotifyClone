package com.example.data.di.module

import com.example.data.AppAPI
import com.example.data.repositoryImpl.MyRepositoryImpl
import com.example.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideMyRepository(api: AppAPI): MyRepository {
        return MyRepositoryImpl(api)
    }
}