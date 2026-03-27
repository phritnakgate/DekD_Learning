package com.example.dekd_learning

import android.app.Application
import com.example.dekd_learning.data.AppContainer
import com.example.dekd_learning.data.DefaultAppContainer

class MyApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}