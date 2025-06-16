package com.example.thmanyah.presentation.features.home.viewModel

import androidx.lifecycle.ViewModel
import com.example.thmanyah.domain.usecase.GetHomeSectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import  javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.thmanyah.presentation.features.home.HomeSectionState
import com.example.thmanyah.presentation.features.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onErrorResume
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@HiltViewModel
class HomeSectionViewModel
@Inject constructor(
    val getHomeSectionsUseCase: GetHomeSectionsUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) :
    ViewModel() {
    private val _homeSectionState = mutableStateOf(HomeSectionState())
    val homeSectionState: State<HomeSectionState> get() = _homeSectionState

    fun onEvent() {
        getHomeSectionsUseCase()
            .onStart {
                _homeSectionState.value =
                    homeSectionState.value.copy(
                        data = "Started ..."
                    )
            }
            .onEach {
                _homeSectionState.value =
                    homeSectionState.value.copy(
                        data = it.sections
                    )

            }.catch {
                _homeSectionState.value =
                    homeSectionState.value.copy(
                        data = it.message.orEmpty()
                    )
            }.flowOn(
                ioDispatcher
            ).launchIn(viewModelScope)
    }


    private fun getHomeSections() {


    }
}