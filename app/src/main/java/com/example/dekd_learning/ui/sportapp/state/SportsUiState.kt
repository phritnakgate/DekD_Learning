package com.example.dekd_learning.ui.sportapp.state

import com.example.dekd_learning.data.Datasource
import com.example.dekd_learning.data.model.Sport

data class SportsUiState(
    val sportsList: List<Sport> = emptyList(),
    val currentSport: Sport = Datasource().defaultSport,
    val isShowingListPage: Boolean = true
)