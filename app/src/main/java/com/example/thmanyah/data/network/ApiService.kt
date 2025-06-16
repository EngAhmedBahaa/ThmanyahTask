package com.example.thmanyah.data.network

import com.example.thmanyah.data.model.HomeSectionResponse
import retrofit2.http.GET

interface ApiService {

    @GET("https://api-v2-b2sit6oh3a-uc.a.run.app/home_sections")
    suspend fun getHomeSections(): HomeSectionResponse

}