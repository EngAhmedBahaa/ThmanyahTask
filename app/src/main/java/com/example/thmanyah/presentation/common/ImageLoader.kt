package com.example.thmanyah.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import com.example.thmanyah.R
import com.example.thmanyah.ui.theme.AppTheme

@Composable
fun ImageLoader(
    modifier: Modifier, url: String,
    contentScale: ContentScale = ContentScale.FillBounds
) {
    AsyncImage(
        modifier = modifier.clip(AppTheme.radius.radiusL),
        model = url,
        placeholder = painterResource(R.drawable.ic_launcher_background),
        contentScale = contentScale,
        contentDescription = null,
    )
}