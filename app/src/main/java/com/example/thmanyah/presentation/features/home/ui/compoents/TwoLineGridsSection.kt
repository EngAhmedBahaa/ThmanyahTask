package com.example.thmanyah.presentation.features.home.ui.compoents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thmanyah.presentation.features.model.ItemUiModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.Black
import com.example.thmanyah.ui.theme.white

@Composable
fun TwoLineGridsSection(
    modifier: Modifier = Modifier,
    title: String,
    items: List<ItemUiModel>
) {
    Column(
        modifier = modifier.height(AppTheme.spaces.spaceHeightBig)
    ) {
        Text(
            modifier = Modifier.padding(
                start = AppTheme.spaces.spaceL,
                bottom = AppTheme.spaces.spaceS
            ),
            text = title,
            color = Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(AppTheme.spaces.spaceXs),
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            items(items) { item ->
                TwoLinesGridItem(
                    item = item
                )
            }
        }
    }
}