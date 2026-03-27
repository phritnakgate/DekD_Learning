package com.example.dekd_learning.data

import com.example.dekd_learning.data.model.MarsPhoto
import com.example.dekd_learning.data.remote.ApiService

interface IRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class Repository(
    private val apiService: ApiService
) : IRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return apiService.getPhotos()
    }
}