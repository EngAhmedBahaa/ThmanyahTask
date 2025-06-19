package com.example.thmanyah.data

import com.example.thmanyah.data.model.HomeSectionResponse
import com.example.thmanyah.data.model.Pagination
import com.example.thmanyah.data.model.Podcast
import com.example.thmanyah.data.model.Sections
import com.example.thmanyah.data.network.ApiService
import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.data.source.HomeRemoteDateSource
import com.example.thmanyah.data.source.remote.HomeRemoteDataSourceImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.domain.model.SectionDto
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeRemoteDataSourceTest {
    var homeRemoteDateSource: HomeRemoteDateSource? = null
    private val apiService: ApiService = mockk()

    @Before
    fun setup() {
        homeRemoteDateSource = HomeRemoteDataSourceImpl(
            apiService
        )
    }

    @Test
    fun `when getHomeSections then return HomeSections`() = runTest {

        val homeSectionResponse = HomeSectionResponse(
            sections = listOf(
                Sections(
                    name = "section 1",
                    type = "square",
                    contentType = "podcast",
                    order = "1",
                    content = listOf(
                        Podcast(
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
            pagination = Pagination(
                nextPage = "2",
                totalPages = 10
            )
        )

        coEvery { apiService.getHomeSections(1) } returns  homeSectionResponse

        val actual = apiService.getHomeSections(1)

        assertEquals(actual , homeSectionResponse)

    }

    @Test
    fun `when search  then return HomeSections`() = runTest {

        val homeSectionResponse = HomeSectionResponse(
            sections = listOf(
                Sections(
                    name = "section 1",
                    type = "square",
                    contentType = "podcast",
                    order = "1",
                    content = listOf(
                        Podcast(
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
            pagination = Pagination(
                nextPage = "2",
                totalPages = 10
            )
        )

        coEvery { apiService.search("search key") } returns  homeSectionResponse

        val actual = apiService.search("search key")

        assertEquals(actual , homeSectionResponse)

    }
}