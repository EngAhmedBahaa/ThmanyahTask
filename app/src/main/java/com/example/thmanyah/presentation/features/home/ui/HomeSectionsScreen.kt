package com.example.thmanyah.presentation.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.TextStyle
import androidx.core.provider.FontsContractCompat.Columns
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.presentation.features.home.ui.compoents.podcast.PodcastItem
import com.example.thmanyah.presentation.features.home.ui.compoents.podcast.PodcastUiModel
import com.example.thmanyah.presentation.features.home.viewModel.HomeSectionViewModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.Black

@Composable
fun HomeSectionScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeSectionViewModel = hiltViewModel()
) {

    val state = viewModel.homeSectionState.value

    if (state.data == null)
        viewModel.onEvent()

    Column (
        modifier = modifier.background(
            color = Black
        )
    ){
        Text(
            text = state.data?.sections?.get(0)?.name ?: "",
            style = TextStyle(
                color = Color.Red
            )
        )
        LazyRow(
            contentPadding = PaddingValues(
                AppTheme.spaces.space2Xs
            )
        ) {
            val list = state.data?.sections?.filter { it.contentType == "podcast" }

            items(list?.get(0)?.content?.size ?: 0) { index ->
                val item = list?.get(0)?.content?.get(index) as SectionContentDto.PodcastDto
                PodcastItem(
                    podcastItem = PodcastUiModel(
                        imageUrl = item.avatarUrl.orEmpty(),
                        title = item.name.orEmpty(),
                        podcastDuration = item.duration?.toDouble() ?: 0.0
                    )
                )

            }

        }
        val list = state.data?.sections?.filter { it.contentType == "podcast" }
        val item = list?.get(0)?.content
        BigSquareItems(items = item ?: emptyList() )
    }
}