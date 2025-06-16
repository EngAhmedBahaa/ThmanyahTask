package com.example.thmanyah.data.model

import com.example.thmanyah.data.model.Content
import com.google.gson.annotations.SerializedName

data class Sections(
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("content_type") var contentType: String? = null,
    @SerializedName("order") var order: Int? = null,
    @SerializedName("content") var content: ArrayList<Content> = arrayListOf()

)