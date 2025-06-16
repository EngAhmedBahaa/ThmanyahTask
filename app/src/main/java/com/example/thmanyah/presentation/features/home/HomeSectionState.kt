package com.example.thmanyah.presentation.features.home

data class HomeSectionState(
    val isLoading: Boolean = false,
    val data: String? = null,
    var error: String = ""
)