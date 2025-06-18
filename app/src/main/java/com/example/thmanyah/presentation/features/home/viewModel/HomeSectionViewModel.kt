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
import com.example.thmanyah.presentation.features.mapper.MapperSectionUiModel
import com.example.thmanyah.presentation.features.model.SectionUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onErrorResume
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.util.ArrayList

@HiltViewModel
class HomeSectionViewModel
@Inject constructor(
    val getHomeSectionsUseCase: GetHomeSectionsUseCase,
    private val mapperSectionUiModel: MapperSectionUiModel,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) :
    ViewModel() {
    private val _homeSectionState = mutableStateOf(HomeSectionState())
    val homeSectionState: State<HomeSectionState> get() = _homeSectionState

    fun getHomeSections() {
        val nextPageNumber = homeSectionState.value.currentPage + 1
        var isLastPageReached = false
        homeSectionState.value.totalPages?.let { totalPages ->
            isLastPageReached = nextPageNumber >= totalPages
        }
        if (isLastPageReached.not()) {
            getHomeSectionsUseCase(nextPageNumber)
                .onStart {
                    _homeSectionState.value =
                        homeSectionState.value.copy(
                            isLoading = true
                        )
                }
                .onEach {
                    val sections: ArrayList<SectionUiModel> = homeSectionState.value.data ?:
                    ArrayList()

                    val listOfUiSection = it.sections?.map { section ->
                        mapperSectionUiModel.map(section)
                    }
                     listOfUiSection?.let { it1 ->
                        sections.addAll(
                            it1
                        )
                    }
                  //   sections.sortBy {it.order}

                    _homeSectionState.value =
                        homeSectionState.value.copy(
                            isLoading = false,
                            data = sections,
                            totalPages = it.totalPages,
                            currentPage = nextPageNumber
                        )

                }.catch {
                    _homeSectionState.value =
                        homeSectionState.value.copy(
                            isLoading = false,
                            error = it.message.orEmpty()
                        )
                }.flowOn(
                    ioDispatcher
                ).launchIn(viewModelScope)
        }
    }

}