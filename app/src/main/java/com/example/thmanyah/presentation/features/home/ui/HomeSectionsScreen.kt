package com.example.thmanyah.presentation.features.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thmanyah.presentation.features.home.viewModel.HomeSectionViewModel

@Composable
fun HomeSectionScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeSectionViewModel = hiltViewModel()
) {

    var state = viewModel.homeSectionState.value

    if (state.data.isNullOrEmpty())
        viewModel.onEvent()

    Text(
        text = state.data.orEmpty()
    )

}