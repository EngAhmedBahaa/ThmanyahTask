package com.example.thmanyah.presentation.features.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thmanyah.presentation.features.home.viewModel.HomeSectionViewModel

@Composable
fun HomeSectionScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeSectionViewModel = hiltViewModel()
) {

    val state = viewModel.homeSectionState.value

    if (state.data.isNullOrEmpty())
        viewModel.onEvent()

    Text(
        text = state.data.orEmpty(),
        style = TextStyle(
            color = Color.Red
        )
    )

}