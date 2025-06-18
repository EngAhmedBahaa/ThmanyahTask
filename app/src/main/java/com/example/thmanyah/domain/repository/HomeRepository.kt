package com.example.thmanyah.domain.repository

import com.example.thmanyah.domain.model.HomeSectionsDto
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getHomeSections(pageNumber : Int): Flow<HomeSectionsDto>

    fun searchSections(searchKey : String): Flow<HomeSectionsDto>

}