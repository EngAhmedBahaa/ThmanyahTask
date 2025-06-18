package com.example.thmanyah.presentation.features.home

import com.example.thmanyah.presentation.features.home.ui.model.SectionUiModel

data class HomeSectionState(
    val isLoading: Boolean = false,
    val data: ArrayList<SectionUiModel>? = null,
    val currentPage: Int = 0,
    val totalPages: Int? = null,
    var error: String = ""
)