package com.example.thmanyah.domain.usecase

import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(
    private val repositoryImpl: HomeRepositoryImpl
) {
    operator fun invoke(searchKey: String): Flow<HomeSectionsDto> {
        return repositoryImpl.searchSections(searchKey)
    }

}