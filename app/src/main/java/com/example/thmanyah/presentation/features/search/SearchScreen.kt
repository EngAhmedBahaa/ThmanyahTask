package com.example.thmanyah.presentation.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thmanyah.presentation.features.home.ui.compoents.BigSquareItems
import com.example.thmanyah.presentation.features.home.ui.compoents.QueueSection
import com.example.thmanyah.presentation.features.home.ui.compoents.SquarSection
import com.example.thmanyah.presentation.features.home.ui.compoents.TwoLineGridsSection
import com.example.thmanyah.presentation.features.home.ui.model.ItemType
import com.example.thmanyah.presentation.features.home.viewModel.HomeSectionViewModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.Black

class SearchScreen {
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeSectionViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    val state = viewModel.homeSectionState.value


    if (state.data == null)
        viewModel.getHomeSections()

    // Observe when user reaches the end of the list
    LaunchedEffect(listState.firstVisibleItemIndex, listState.layoutInfo.totalItemsCount) {
        val lastVisibleItemIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        if (lastVisibleItemIndex == listState.layoutInfo.totalItemsCount - 1) {
            viewModel.getHomeSections()
        }
    }

    Column(
        modifier = modifier.background(
            color = Black
        ).padding(bottom = AppTheme.spaces.spaceL)
    ) {

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(
                AppTheme.spaces.space2Xs
            )
        ) {

            items(state.data ?: emptyList()) { item ->
                when (item.type) {
                    ItemType.Queue -> QueueSection(
                        title = item.title,
                        items = item.content
                    )

                    ItemType.Square -> SquarSection(
                        title = item.title,
                        items = item.content
                    )

                    ItemType.BigSquare -> BigSquareItems(
                        title = item.title,
                        items = item.content
                    )

                    ItemType.TwoLinesGrid -> TwoLineGridsSection(
                        title = item.title,
                        items = item.content
                    )
                }

            }

        }
    }
}