package com.example.dekd_learning.ui.inventoryapp.state

import com.example.dekd_learning.data.model.ItemDetails

data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)