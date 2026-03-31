package com.example.dekd_learning.ui.blurapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.WorkInfo
import com.example.dekd_learning.data.Datasource
import com.example.dekd_learning.ui.blurapp.state.BlurUiState
import com.example.dekd_learning.utils.KEY_IMAGE_URI
import com.example.dekd_learning.workers.BluromaticRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BlurViewModel(private val repository: BluromaticRepository) : ViewModel() {
    internal val blurAmount = Datasource.BlurAmountData.blurAmount

    val blurUiState: StateFlow<BlurUiState> = repository.outputWorkInfo
        .map { info ->
            val outputImageUri = info.outputData.getString(KEY_IMAGE_URI)
            when {
                info.state.isFinished && !outputImageUri.isNullOrEmpty() -> {
                    BlurUiState.Complete(outputUri = outputImageUri)
                }
                info.state == WorkInfo.State.CANCELLED -> {
                    BlurUiState.Default
                }
                else -> BlurUiState.Loading
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = BlurUiState.Default
        )
    
    fun applyBlur(blurLevel: Int) {
        repository.applyBlur(blurLevel)
    }

    fun cancelWork() {
        repository.cancelWork()
    }
}

