package com.example.thmanyah.data.repository

import com.example.thmanyah.data.network.ApiService
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    HomeRepository {
    override suspend fun getHomeSections(): Flow<HomeSectionsDto> = flow {
        apiService.getHomeSections()
    }

}