package com.example.thmanyah.presentation.features.home

import com.example.thmanyah.domain.model.HomeSectionsDto

data class HomeSectionState(
    val isLoading: Boolean = false,
    val data: HomeSectionsDto? = null,
    var error: String = ""
)