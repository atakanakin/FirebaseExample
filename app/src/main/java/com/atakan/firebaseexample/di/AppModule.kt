package com.atakan.firebaseexample.di

import com.atakan.firebaseexample.common.Constants
import com.atakan.firebaseexample.data.remote.RickApi
import com.atakan.firebaseexample.data.repository.RickRepositoryImpl
import com.atakan.firebaseexample.domain.repository.RickRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickApi(): RickApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickRepository(api: RickApi): RickRepository {
        return RickRepositoryImpl(api)
    }
}