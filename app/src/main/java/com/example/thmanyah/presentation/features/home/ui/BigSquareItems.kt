package com.example.thmanyah.presentation.features.home.ui


import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalConfiguration
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.presentation.features.home.ui.compoents.podcast.PodcastItem
import com.example.thmanyah.presentation.features.home.ui.compoents.podcast.PodcastUiModel

@Composable
fun BigSquareItems(modifier: Modifier = Modifier,
                   items : List<SectionContentDto>){

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    // LazyRow displaying one item per swipe
    LazyRow(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items.size) { index ->
            val item = items[index] as SectionContentDto.PodcastDto
            PodcastItem(
                modifier = Modifier.width(screenWidth),
                        podcastItem = PodcastUiModel(
                        imageUrl = item.avatarUrl.orEmpty(),
                        title = item.name.orEmpty(),
                        podcastDuration = item.duration?.toDouble() ?: 0.0
                    )
            )
        }
    }
}