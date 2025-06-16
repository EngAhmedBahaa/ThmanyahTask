package com.example.thmanyah.domain.repository

import com.example.thmanyah.domain.model.HomeSectionsDto
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getHomeSections(): Flow<HomeSectionsDto>

}