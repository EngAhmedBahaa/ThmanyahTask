package com.example.thmanyah.data.di

import android.util.Log
import com.example.thmanyah.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import  com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.domain.repository.HomeRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(logger)
        return Retrofit.Builder()
            .baseUrl("https://api-v2-b2sit6oh3a-uc.a.run.app/")
            .client(
               clientBuilder.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}