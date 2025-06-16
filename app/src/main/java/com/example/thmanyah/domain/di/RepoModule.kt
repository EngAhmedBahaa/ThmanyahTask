package com.example.thmanyah.domain.di

import com.example.thmanyah.data.network.ApiService
import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.data.source.HomeRemoteDateSource
import com.example.thmanyah.data.source.remote.HomeRemoteDataSourceImpl
import com.example.thmanyah.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepoModule {

    @Binds
    @Singleton
    fun provideHomeSectionDataSource(homeSectionDataSource: HomeRemoteDataSourceImpl): HomeRemoteDateSource

    @Binds
    @Singleton
    fun providerRepositoryImpl(homeRepository : HomeRepositoryImpl): HomeRepository
}