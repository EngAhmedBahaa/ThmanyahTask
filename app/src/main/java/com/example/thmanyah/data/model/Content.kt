package com.example.thmanyah.data.model
import com.google.gson.annotations.SerializedName

data class Content(

    @SerializedName("podcast_id") var podcastId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("avatar_url") var avatarUrl: String? = null,
    @SerializedName("episode_count") var episodeCount: Int? = null,
    @SerializedName("duration") var duration: Int? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("priority") var priority: Int? = null,
    @SerializedName("popularityScore") var popularityScore: Int? = null,
    @SerializedName("score") var score: Double? = null

)