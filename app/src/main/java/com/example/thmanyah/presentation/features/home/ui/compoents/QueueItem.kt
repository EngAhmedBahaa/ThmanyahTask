package com.example.thmanyah.presentation.features.home.ui.compoents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thmanyah.presentation.common.ImageLoader
import com.example.thmanyah.presentation.features.home.ui.model.ItemUiModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.LightGray
import com.example.thmanyah.ui.theme.white

@Composable
fun QueueItem(
    modifier: Modifier = Modifier,
    item: ItemUiModel
) {
    Box(
        modifier = modifier
            .padding(AppTheme.spaces.spaceXs)
            .width(AppTheme.spaces.space150) // Increase item width
            .height(AppTheme.spaces.space9Xl)

    ) {
        ImageLoader(
            Modifier
                .fillMaxSize(),
            item.imageUrl,
        )
        Column(
            modifier = Modifier
                .padding(AppTheme.spaces.spaceS6)
                .align(Alignment.BottomCenter)
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = AppTheme.spaces.spaceXs) // Optional padding around the box
                    .fillMaxWidth() // Fill the width of the parent
                    .background(
                        color = LightGray, // Background color of the box
                        shape = AppTheme.radius.radiusS
                    ),
                contentAlignment = Alignment.Center // Center the text
            ) {
                Column {
                    Text(
                        text = item.title,
                        color = white,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Text(
                        text = item.subtitle,
                        color = white,
                        fontSize = 14.sp,
                        maxLines = 1
                    )
                }

            }

        }
    }
}