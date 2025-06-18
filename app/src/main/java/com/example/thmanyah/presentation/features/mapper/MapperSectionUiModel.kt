package com.example.thmanyah.presentation.features.mapper

import com.example.thmanyah.domain.model.SectionContentDto
import com.example.thmanyah.domain.model.SectionDto
import com.example.thmanyah.presentation.extenstions.fromMinsToHoursMinFormat
import com.example.thmanyah.presentation.features.model.ItemType
import com.example.thmanyah.presentation.features.model.ItemUiModel
import com.example.thmanyah.presentation.features.model.SectionUiModel
import javax.inject.Inject

class MapperSectionUiModel @Inject constructor() {

    fun map(section: SectionDto): SectionUiModel =
        SectionUiModel(
            title = section.name.orEmpty(),
            content = section.content?.map {
                mapContentToUiModel(it)
            } ?: emptyList(),
            order = section.order ?: 0,
            type = ItemType.fromString(section.type.orEmpty()) ?: ItemType.Square
        )

    private fun mapContentToUiModel(content: SectionContentDto): ItemUiModel {
        return when (content) {
            is SectionContentDto.AudioArticleDto -> ItemUiModel(
                imageUrl = content.avatarUrl.orEmpty(),
                title = content.name.orEmpty(),
                subtitle = content.authorName.orEmpty()
            )

            is SectionContentDto.AudioBookDto -> ItemUiModel(
                imageUrl = content.avatarUrl.orEmpty(),
                title = content.name.orEmpty(),
                subtitle = content.authorName.orEmpty()
            )

            is SectionContentDto.EpisodeDto -> ItemUiModel(
                imageUrl = content.avatarUrl.orEmpty(),
                title = content.name.orEmpty(),
                subtitle = content.duration?.fromMinsToHoursMinFormat().orEmpty()
            )

            is SectionContentDto.PodcastDto -> ItemUiModel(
                imageUrl = content.avatarUrl.orEmpty(),
                title = content.name.orEmpty(),
                subtitle = content.episodeCount.toString() + " " + "episodes"
            )
        }
    }
}