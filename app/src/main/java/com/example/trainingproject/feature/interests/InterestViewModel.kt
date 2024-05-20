package com.example.trainingproject.feature.interests

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.core.data.util.NetworkUtils
import com.example.trainingproject.core.domain.FetchInterestsUseCase
import com.example.trainingproject.core.domain.FetchTopicsFromDBUseCase
import com.example.trainingproject.core.domain.InsertTopicsUseCase
import com.example.trainingproject.core.result.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    private val fetchInterestsUseCase: FetchInterestsUseCase,
    private val insertTopicsUseCase: InsertTopicsUseCase,
    private val fetchTopicsFromDBUseCase: FetchTopicsFromDBUseCase,
    networkUtils : NetworkUtils,
    @ApplicationContext context: Context,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<List<InterestsItemUiModel>>>(UIState.Loading)
    val uiState: StateFlow<UIState<List<InterestsItemUiModel>>> get() = _uiState

    init {
        if (networkUtils.isOnline(context)) {
            fetchInterestsFromAPI()
        } else {
            fetchInterestsFromDB()
        }
    }

    private fun fetchInterestsFromAPI() {
        viewModelScope.launch {
            try {
                val topics = fetchInterestsUseCase()
                _uiState.emit(UIState.Success(topics))
                insertTopicsUseCase()
            } catch (e: Exception) {
                _uiState.emit(UIState.Error("Error Fetching Data"))
            }
        }
    }

    private fun fetchInterestsFromDB() {
        viewModelScope.launch {
            try {
                val topics = fetchTopicsFromDBUseCase()
                _uiState.emit(UIState.Success(topics))
            } catch (e: Exception) {
                _uiState.emit(UIState.Error("Error Fetching Data"))
            }
        }
    }
}

