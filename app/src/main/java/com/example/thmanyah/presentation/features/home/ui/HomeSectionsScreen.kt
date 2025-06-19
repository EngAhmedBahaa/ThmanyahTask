package com.example.thmanyah.presentation.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thmanyah.presentation.features.home.viewModel.HomeSectionViewModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.Black
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.example.thmanyah.R
import com.example.thmanyah.presentation.features.home.ui.compoents.BigSquareItems
import com.example.thmanyah.presentation.features.home.ui.compoents.ErrorFullScreen
import com.example.thmanyah.presentation.features.home.ui.compoents.HomeLoadingScreen
import com.example.thmanyah.presentation.features.home.ui.compoents.QueueSection
import com.example.thmanyah.presentation.features.home.ui.compoents.ShimmerItem
import com.example.thmanyah.presentation.features.home.ui.compoents.SquarSection
import com.example.thmanyah.presentation.features.home.ui.compoents.SquareItem
import com.example.thmanyah.presentation.features.home.ui.compoents.TwoLineGridsSection
import com.example.thmanyah.presentation.features.model.ItemType

@Composable
fun HomeSectionScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeSectionViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    val state = viewModel.homeSectionState.value


    if (state.isInitiated == false)
        viewModel.getHomeSections()

    // Observe when user reaches the end of the list
    LaunchedEffect(listState.firstVisibleItemIndex, listState.layoutInfo.totalItemsCount) {
        val lastVisibleItemIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        if (lastVisibleItemIndex == listState.layoutInfo.totalItemsCount - 1) {
            viewModel.getHomeSections()
        }
    }

    when {
        state.isShimmerEnabled -> {
            HomeLoadingScreen()
        }
        state.error.isEmpty().not() -> {
            ErrorFullScreen(
                modifier = Modifier.fillMaxSize(),
                retryAction = {
                    viewModel.getHomeSections()
                },
                title = stringResource(R.string.error_title),
                message = state.error,
            )
        }
        else -> {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = AppTheme.spaces.spaceL,
                        bottom = AppTheme.spaces.spaceL
                    )
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
    }
}