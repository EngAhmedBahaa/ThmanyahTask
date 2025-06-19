package com.example.thmanyah.presentation.features.home.ui.compoents

import androidx.compose.foundation.background
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
import com.example.thmanyah.presentation.features.model.ItemUiModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.Black
import com.example.thmanyah.ui.theme.Gray
import com.example.thmanyah.ui.theme.white

@Composable
fun BigSquareItem(
    modifier: Modifier = Modifier,
    item: ItemUiModel
) {
    Box(
        modifier = modifier
            .padding(AppTheme.spaces.spaceXs)
            .fillMaxWidth()
            .background(Gray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ImageLoader(
                Modifier
                    .height(AppTheme.spaces.space150)
                    .width(AppTheme.spaces.spaceHeightBig),
                item.imageUrl
            )
            Column(
                modifier = Modifier
                    .padding(AppTheme.spaces.spaceS6)
            ) {
                Text(
                    text = item.title,
                    color = Black,
                    maxLines = 2
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AppTheme.spaces.space2Xs)
                )

                Text(
                    text = item.subtitle,
                    color = Black,
                    maxLines = 1
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AppTheme.spaces.space5Xl)
                )

            }
        }
    }
}

@Composable
fun BigSquareItemPreview() {

    BigSquareItem(
        item = ItemUiModel(
            imageUrl = "",
            title = "title",
            subtitle = "subtitle"
        )
    )
}