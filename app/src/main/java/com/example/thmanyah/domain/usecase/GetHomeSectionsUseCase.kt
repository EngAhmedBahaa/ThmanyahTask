package com.example.thmanyah.domain.usecase

import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetHomeSectionsUseCase @Inject constructor(
    private val repositoryImpl: HomeRepositoryImpl
) {
      operator fun invoke(pageNumber : Int): Flow<HomeSectionsDto> {
         return repositoryImpl.getHomeSections(pageNumber)
      }

}