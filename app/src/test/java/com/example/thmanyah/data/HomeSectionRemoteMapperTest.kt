package com.example.thmanyah.data

import org.junit.Test
import com.example.thmanyah.data.mapper.HomeSectionRemoteMapper
import com.example.thmanyah.data.model.HomeSectionResponse
import com.example.thmanyah.data.model.Pagination
import com.example.thmanyah.data.model.Podcast
import com.example.thmanyah.data.model.Sections
import com.example.thmanyah.domain.model.HomeSectionsDto
import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.domain.model.SectionDto
import org.junit.Assert.assertEquals

class HomeSectionRemoteMapperTest {

    private var homeSectionRemoteMapper = HomeSectionRemoteMapper()

    @Test
    fun `map HomeSectionResponse to  HomeSectionsDto`() {
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


        val result = homeSectionRemoteMapper.map(homeSectionResponse)

        assertEquals(result , expected)
    }
}