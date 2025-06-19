package com.example.thmanyah.presentation.features.home.ui.compoents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thmanyah.presentation.extenstions.shimmerEffect
import com.example.thmanyah.ui.theme.AppTheme


@Composable
fun ShimmerItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(AppTheme.spaces.space9Xl)
            .padding(horizontal = AppTheme.spaces.space2Xs)
    ) {
        // Image shimmer
        Box(
            modifier = Modifier
                .size(AppTheme.spaces.space8Xl)
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.spaces.spaceS)
        )

        // Title shimmer (2 lines)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp) // Approximate line height
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.spaces.space2Xs)
        )

        // Subtitle shimmer (1 line)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp) // Approximate subtitle height
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppTheme.spaces.space2Xs)
        )
    }
}
