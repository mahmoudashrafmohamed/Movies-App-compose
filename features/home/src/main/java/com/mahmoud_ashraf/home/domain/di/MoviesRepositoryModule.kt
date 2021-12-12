package com.mahmoud_ashraf.home.domain.di

import com.mahmoud_ashraf.home.data.repository.MoviesRepositoryImpl
import com.mahmoud_ashraf.home.data.repository.remote.MovieAPI
import com.mahmoud_ashraf.home.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
 @Module
    @InstallIn(SingletonComponent::class)
    object MoviesRepositoryModule {

        @Singleton
        @Provides
        fun provideMoviesRepository(
            remote : MovieAPI
        ): MoviesRepository {
            return MoviesRepositoryImpl(remote)
        }
    }
