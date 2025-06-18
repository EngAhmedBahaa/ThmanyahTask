package com.example.thmanyah.presentation.features.search

import com.example.thmanyah.presentation.features.model.SectionUiModel

data class SearchScreenState(
    val isLoading: Boolean = false,
    val data: List<SectionUiModel>? = null,
    var error: String = ""
)