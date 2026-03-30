package com.example.dekd_learning.data

import android.content.Context
import com.example.dekd_learning.data.local.AppDatabase
import com.example.dekd_learning.data.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

interface AppContainer {
    val repository : IRepository
}

class DefaultAppContainer(context: Context) : AppContainer {
    private val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val repository: Repository by lazy {
        Repository(
            apiService = retrofitService,
            itemDao = AppDatabase.getDatabase(context.applicationContext).itemDao()
            )
    }
}