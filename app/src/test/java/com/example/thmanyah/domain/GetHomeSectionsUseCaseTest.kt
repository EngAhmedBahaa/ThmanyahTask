package com.example.thmanyah.domain

import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.domain.model.SectionDto
import com.example.thmanyah.domain.usecase.GetHomeSectionsUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetHomeSectionsUseCaseTest {

    private var getHomeSectionsUseCase: GetHomeSectionsUseCase? = null
    private val repositoryImpl: HomeRepositoryImpl = mockk()

    @Before
    fun setup() {
        getHomeSectionsUseCase = GetHomeSectionsUseCase(
            repositoryImpl
        )
    }


    @Test
    fun `when getHomeSections then return HomeSections`() =
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


            every { repositoryImpl.getHomeSections(pageNumber) } returns flowOf(
                expected
            )

            val actual = getHomeSectionsUseCase!!.invoke(pageNumber).first()

            assertEquals(actual, expected)
        }

}