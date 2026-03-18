package com.example.dekd_learning.ui.sportapp

import androidx.lifecycle.ViewModel
import com.example.dekd_learning.data.Datasource
import com.example.dekd_learning.data.model.Sport
import com.example.dekd_learning.ui.sportapp.state.SportsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * View Model for Sports app
 */
class SportsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        SportsUiState(
            sportsList = Datasource().getSportsData(),
            currentSport = Datasource().getSportsData().getOrElse(0) {
                Datasource().defaultSport
            }
        )
    )
    val uiState: StateFlow<SportsUiState> = _uiState

    fun updateCurrentSport(selectedSport: Sport) {
        _uiState.update {
            it.copy(currentSport = selectedSport)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }


    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

