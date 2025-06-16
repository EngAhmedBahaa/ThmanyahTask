package com.example.thmanyah.data.model

import com.google.gson.annotations.SerializedName

data class HomeSectionResponse(
    @SerializedName("sections") var sections: ArrayList<Sections> = arrayListOf(),
    @SerializedName("pagination") var pagination: Pagination? = Pagination()

)