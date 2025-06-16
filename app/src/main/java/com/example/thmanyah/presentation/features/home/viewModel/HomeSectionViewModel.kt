package com.example.thmanyah.presentation.features.home.viewModel

import androidx.lifecycle.ViewModel
import com.example.thmanyah.domain.usecase.GetHomeSectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import  javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.thmanyah.presentation.features.home.HomeSectionState

@HiltViewModel
class HomeSectionViewModel
@Inject constructor() :
    ViewModel() {
    private val _homeSectionState = mutableStateOf(HomeSectionState())
    val homeSectionState: State<HomeSectionState> get() = _homeSectionState

    fun onEvent() {
        getHomeSections()
    }


    private fun getHomeSections() {
        _homeSectionState.value = homeSectionState.value.copy(
            data = "data data data"
        )
//        getHomeSectionsUseCase().onEach {
//            _homeSectionState.value =
//                homeSectionState.value.copy(
//                    data = it.sections
//                )
//
//        }.catch {
//            _homeSectionState.value =
//                homeSectionState.value.copy(
//                    error = it.message.orEmpty()
//                )
//        }
    }
}