package com.example.dekd_learning.data.remote

import com.example.dekd_learning.data.model.MarsPhoto
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
