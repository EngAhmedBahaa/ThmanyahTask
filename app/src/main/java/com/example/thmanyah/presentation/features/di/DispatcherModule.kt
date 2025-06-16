package com.example.thmanyah.presentation.features.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule{
    @IoDispatcher
    @Provides
    fun providesIoDispatcher() : CoroutineDispatcher = Dispatchers.IO

}
@Qualifier
@Retention
annotation class IoDispatcher