package com.example.thmanyah.presentation.features.home.ui.compoents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.presentation.common.ImageLoader
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.thmanyah.presentation.features.model.ItemUiModel
import com.example.thmanyah.ui.theme.white

@Composable
fun SquareItem(modifier: Modifier = Modifier,
                podcastItem : ItemUiModel
) {
    Column(
        modifier = modifier
            .width(AppTheme.spaces.space9Xl)
            .padding(horizontal = AppTheme.spaces.space2Xs)
    ) {
        ImageLoader(
            Modifier.size(AppTheme.spaces.space8Xl),
            podcastItem.imageUrl
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.spaces.spaceS)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = podcastItem.title,
            color = white,
            maxLines = 2
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.spaces.space2Xs)
        )
        Text(
            text = podcastItem.subtitle,
            color = white,
            maxLines = 1
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.spaces.space2Xs)
        )
    }
}
@Preview
@Composable
fun PodcastItemPreview() {
    SquareItem(
        podcastItem = ItemUiModel(
            imageUrl = "https://media.npr.org/assets/img/2022/09/23/up-first_tile_npr-network-01_sq-cd1dc7e35846274fc57247cfcb9cd4dddbb2d635.jpg?s=1400&c=66&f=jpg",
            title = "Up First from NPR",
            subtitle = "11:50"
        )
    )
}
