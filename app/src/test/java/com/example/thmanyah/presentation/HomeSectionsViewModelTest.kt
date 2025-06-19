package com.example.thmanyah.presentation

import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.domain.model.SectionDto
import com.example.thmanyah.domain.usecase.GetHomeSectionsUseCase
import com.example.thmanyah.presentation.extenstions.fromMinsToHoursMinFormat
import com.example.thmanyah.presentation.features.home.HomeSectionState
import com.example.thmanyah.presentation.features.home.viewModel.HomeSectionViewModel
import com.example.thmanyah.presentation.features.mapper.MapperSectionUiModel
import com.example.thmanyah.presentation.features.model.ItemType
import com.example.thmanyah.presentation.features.model.ItemUiModel
import com.example.thmanyah.presentation.features.model.SectionUiModel
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class HomeSectionsViewModelTest {

    private var searchViewModel: HomeSectionViewModel? = null
    val getHomeSectionsUseCase: GetHomeSectionsUseCase = mockk()
    private val homeSectionState = mockk<MutableStateFlow<HomeSectionState>>()
    private val mapperSectionUiModel: MapperSectionUiModel = mockk()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        searchViewModel = HomeSectionViewModel(
            getHomeSectionsUseCase = getHomeSectionsUseCase,
            mapperSectionUiModel = mapperSectionUiModel,
            ioDispatcher = testDispatcher
        )
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when search by any word then return HomeSections`() = runTest {
        val searchKey = "key"

        val response = HomeSectionsDto(
            sections = listOf(
                SectionDto(
                    name = "section 1",
                    type = "square",
                    contentType = "podcast",
                    order = 1,
                    content = listOf(
                        SectionContentDto.PodcastDto(
                            podcastId = "1",
                            name = "podcast",
                            description = "descripton",
                            avatarUrl = "url",
                            episodeCount = 10,
                            duration = 1000,
                            language = "ar",
                            priority = "1",
                            popularityScore = "220",
                            score = "22323"
                        )
                    )
                )
            ),
            totalPages = 10
        )
        var expected = ArrayList<SectionUiModel>()
        expected.add (SectionUiModel(
            title = "section 1",
            content = listOf(
                ItemUiModel(
                    imageUrl = "url",
                    title = "podcast",
                    subtitle = 1000.fromMinsToHoursMinFormat()
                )
            ),
            order = 1,
            type =  ItemType.Square
        ))

        every {getHomeSectionsUseCase.invoke(1)  } returns  flowOf(
            response
        )
        every { mapperSectionUiModel.map(
            response.sections!![0]
        ) } returns expected.get(0)

        every { homeSectionState.value } returns  HomeSectionState(
            data = expected
        )


        runBlocking {
            searchViewModel!!.getHomeSections()
        }

        coVerify(exactly = 1) { getHomeSectionsUseCase(any()) }
    }
}