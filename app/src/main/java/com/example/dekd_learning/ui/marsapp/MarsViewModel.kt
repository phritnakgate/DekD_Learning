package com.example.dekd_learning.ui.marsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dekd_learning.MyApplication
import com.example.dekd_learning.data.IRepository

class MarsViewModel(private val repository: IRepository) : ViewModel() {
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val repository = application.container.repository
                MarsViewModel(repository = repository)
            }
        }
    }
}