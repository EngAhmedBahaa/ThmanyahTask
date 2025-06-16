package com.example.thmanyah.data.repository

import com.example.thmanyah.data.network.ApiService
import com.example.thmanyah.data.source.remote.HomeRemoteDataSourceImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeSectionDataSource: HomeRemoteDataSourceImpl) :
    HomeRepository {
    override  fun getHomeSections(): Flow<HomeSectionsDto> =
        homeSectionDataSource.getHomeSections().map {
            HomeSectionsDto(it.sections[0].name ?: "Empty")
        }



    fun map (data : String) : HomeSectionsDto =
        HomeSectionsDto(sections = data)
}