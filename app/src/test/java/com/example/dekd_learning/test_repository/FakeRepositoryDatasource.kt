package com.example.dekd_learning.test_repository

import com.example.dekd_learning.data.model.MarsPhoto

object FakeRepositoryDatasource {
    const val idOne = "img1"
    const val imgOne = "url.1"
    const val idTwo = "img2"
    const val imgTwo = "url.2"
    val photosList = listOf(
        MarsPhoto(id = idOne, imgSrc = imgOne),
        MarsPhoto(id = idTwo, imgSrc = imgTwo)
    )
}