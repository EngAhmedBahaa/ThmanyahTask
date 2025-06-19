package com.example.thmanyah.domain

import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.domain.model.SectionDto
import com.example.thmanyah.domain.usecase.GetSearchResultUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetSearchResultUseCaseTest {

    private var getSearchResultUseCase: GetSearchResultUseCase? = null
    private val repositoryImpl: HomeRepositoryImpl = mockk()

    @Before
    fun setup() {
        getSearchResultUseCase = GetSearchResultUseCase(
            repositoryImpl
        )
    }


    @Test
    fun `when search by any word then return HomeSections`() =
        runTest {
            val pageNumber = 1
            val expected = HomeSectionsDto(
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


            every { repositoryImpl.searchSections("search key") } returns flowOf(
                expected
            )

            val actual = getSearchResultUseCase!!.invoke("search key").first()

            assertEquals(actual, expected)
        }

}