package com.example.thmanyah.presentation.features.home.ui.compoents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.thmanyah.presentation.common.ImageLoader
import com.example.thmanyah.presentation.features.home.ui.model.ItemUiModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.white

@Composable
fun TwoLinesGridItem(
    modifier: Modifier = Modifier,
    item: ItemUiModel
) {
    Box(
        modifier = modifier
            .padding(AppTheme.spaces.spaceXs)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ImageLoader(
                Modifier
                    .height(AppTheme.spaces.space7Xl)
                    .width(AppTheme.spaces.space7Xl),
                item.imageUrl
            )
            Column(
                modifier = Modifier
                    .padding(AppTheme.spaces.spaceS6)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = item.title,
                    color = white,
                    maxLines = 2
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AppTheme.spaces.space2Xs)
                )

                Text(
                    text = item.subtitle,
                    color = white,
                    maxLines = 1
                )
            }
        }
    }
}