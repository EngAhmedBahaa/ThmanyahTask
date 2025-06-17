package com.example.thmanyah.data.repository

import com.example.thmanyah.data.mapper.HomeSectionRemoteMapper
import com.example.thmanyah.data.source.remote.HomeRemoteDataSourceImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeSectionRemoteMapper: HomeSectionRemoteMapper,
    private val homeSectionDataSource: HomeRemoteDataSourceImpl
) :
    HomeRepository {
    override fun getHomeSections(): Flow<HomeSectionsDto> {
       return homeSectionDataSource.getHomeSections().map {
            homeSectionRemoteMapper.map(it)
        }
    }
}