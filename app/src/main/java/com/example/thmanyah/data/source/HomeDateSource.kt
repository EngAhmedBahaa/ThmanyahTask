package com.example.thmanyah.data.source

import com.example.thmanyah.data.model.HomeSectionResponse
import kotlinx.coroutines.flow.Flow

interface HomeRemoteDateSource {
    fun getHomeSections(): Flow<HomeSectionResponse>
}

/**
 * if needed
 */
interface HomeLocalDateSource