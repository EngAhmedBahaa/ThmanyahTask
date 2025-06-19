package com.example.thmanyah.presentation.features.home

import com.example.thmanyah.presentation.features.model.SectionUiModel

data class HomeSectionState(
    val isShimmerEnabled: Boolean = false,
    val isInitiated : Boolean = false,
    val data: ArrayList<SectionUiModel>? = null,
    val currentPage: Int = 0,
    val totalPages: Int? = null,
    var error: String = ""
)