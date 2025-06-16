package com.example.thmanyah.data.source.remote

import com.example.thmanyah.data.model.HomeSectionResponse
import com.example.thmanyah.data.network.ApiService
import com.example.thmanyah.data.source.HomeRemoteDateSource
import com.example.thmanyah.domain.model.HomeSectionsDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRemoteDataSourceImpl
    @Inject constructor(
     private val apiService: ApiService
    ): HomeRemoteDateSource {
    override fun getHomeSections(): Flow<HomeSectionResponse> = flow {
     emit(apiService.getHomeSections())
    }

}