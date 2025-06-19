package com.example.thmanyah.data

import com.example.thmanyah.data.mapper.HomeSectionRemoteMapper
import com.example.thmanyah.data.model.HomeSectionResponse
import com.example.thmanyah.data.model.Pagination
import com.example.thmanyah.data.model.Podcast
import com.example.thmanyah.data.model.Sections
import com.example.thmanyah.data.repository.HomeRepositoryImpl
import com.example.thmanyah.data.source.remote.HomeRemoteDataSourceImpl
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.domain.model.SectionDto
import com.example.thmanyah.domain.repository.HomeRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeRepositoryTest {
    private var repository: HomeRepository? = null

    private val homeSectionRemoteMapper: HomeSectionRemoteMapper = mockk()
    private val homeSectionDataSource: HomeRemoteDataSourceImpl = mockk()

    @Before
    fun setup() {
        repository = HomeRepositoryImpl(
            homeSectionRemoteMapper,
            homeSectionDataSource,
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

            every { homeSectionRemoteMapper.map(homeSectionResponse) } returns expected
            every { homeSectionDataSource.getHomeSections(pageNumber) } returns flowOf(
                homeSectionResponse
            )

            val actual = repository!!.getHomeSections(pageNumber).first()

            assertEquals(actual , expected)
        }


    @Test
    fun `when searchSections then return HomeSections`() =
        runTest {
            val searchKey = "Search fake"
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

            every { homeSectionRemoteMapper.map(homeSectionResponse) } returns expected
            every { homeSectionDataSource.search(searchKey) } returns flowOf(
                homeSectionResponse
            )

            val actual = repository!!.searchSections(searchKey).first()

            assertEquals(actual , expected)
        }
}