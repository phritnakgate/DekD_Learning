package com.example.dekd_learning.ui.inventoryapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.dekd_learning.MyApplication
import com.example.dekd_learning.data.IRepository
import com.example.dekd_learning.data.model.ItemDetails
import com.example.dekd_learning.ui.inventoryapp.state.ItemUiState
import com.example.dekd_learning.utils.extensions.toItem

class InventoryViewModel(private val repository: IRepository): ViewModel() {

    var itemUiState by mutableStateOf(ItemUiState())
        private set

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }

    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            repository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val repository = application.container.repository
                InventoryViewModel(repository = repository)
            }
        }
    }
}