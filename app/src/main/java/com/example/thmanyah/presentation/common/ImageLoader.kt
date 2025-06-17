package com.example.thmanyah.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.example.thmanyah.ui.theme.AppTheme

@Composable
fun ImageLoader(modifier: Modifier, url: String) {
    AsyncImage(
        modifier = modifier.clip(AppTheme.radius.radiusL),
        model = url,
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
    )
}