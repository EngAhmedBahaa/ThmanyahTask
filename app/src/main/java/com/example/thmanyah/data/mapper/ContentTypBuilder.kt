package com.example.thmanyah.data.mapper

import com.example.thmanyah.data.model.AudioArticle
import com.example.thmanyah.data.model.AudioBook
import com.example.thmanyah.data.model.Content
import com.example.thmanyah.data.model.Episode
import com.example.thmanyah.data.model.Podcast
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class ContentTypBuilder : JsonDeserializer<Content> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Content {
        val jsonObject = json.asJsonObject
        val episodeId = jsonObject.has("episode_id")
        val podcastId = jsonObject.has("podcast_id")
        val audiobookId = jsonObject.has("audiobook_id")
        val articleId = jsonObject.has("article_id")

        return when {
            episodeId -> context.deserialize(json, Episode::class.java)
            audiobookId -> context.deserialize(json, AudioBook::class.java)
            articleId -> context.deserialize(json, AudioArticle::class.java)
            podcastId -> context.deserialize(json, Podcast::class.java)
            else -> throw JsonParseException("Unknown content type: podcastId= $podcastId  | episodeId=$episodeId |audiobookId= $audiobookId | articleId=$articleId")
        }
    }
}