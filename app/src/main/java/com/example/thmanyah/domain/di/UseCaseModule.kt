package com.example.thmanyah.domain.di
import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.domain.usecase.GetHomeSectionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun productListUseCaseProvider(repositoryImpl: HomeRepositoryImpl) : GetHomeSectionsUseCase {
        return GetHomeSectionsUseCase(repositoryImpl)
    }
}