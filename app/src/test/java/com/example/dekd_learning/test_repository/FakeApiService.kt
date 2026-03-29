package com.example.dekd_learning.test_repository

import com.example.dekd_learning.data.model.MarsPhoto
import com.example.dekd_learning.data.remote.ApiService

class FakeApiService : ApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeRepositoryDatasource.photosList
    }
}