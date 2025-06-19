package com.example.thmanyah.presentation.features.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.thmanyah.R
import com.example.thmanyah.presentation.features.home.ui.compoents.BigSquareItems
import com.example.thmanyah.presentation.features.home.ui.compoents.ErrorFullScreen
import com.example.thmanyah.presentation.features.home.ui.compoents.QueueSection
import com.example.thmanyah.presentation.features.home.ui.compoents.SquarSection
import com.example.thmanyah.presentation.features.home.ui.compoents.TwoLineGridsSection
import com.example.thmanyah.presentation.features.model.ItemType
import com.example.thmanyah.presentation.features.home.viewModel.HomeSectionViewModel
import com.example.thmanyah.ui.theme.AppTheme
import com.example.thmanyah.ui.theme.Black

class SearchScreen {
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val listState = rememberLazyListState()
    val state = viewModel.searchScreenState.value
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }


            Column(
                modifier = modifier
                    .padding(bottom = AppTheme.spaces.spaceL)
            ) {

                TextField(
                    value = searchQuery.value,
                    onValueChange = {
                        searchQuery.value = it
                        viewModel.getSearchResult(it.text)
                    },
                    placeholder = { Text("Search...") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Black,
                        unfocusedTextColor = Black
                    )
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AppTheme.spaces.spaceL)
                )

                when {
                    state.error.isEmpty().not() -> {
                        ErrorFullScreen(
                            modifier = Modifier.fillMaxSize(),
                            retryAction = {
                                viewModel.getSearchResult(searchQuery.value.text)
                            },
                            title = stringResource(R.string.error_title),
                            message = state.error,
                        )
                    }

                    else ->
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