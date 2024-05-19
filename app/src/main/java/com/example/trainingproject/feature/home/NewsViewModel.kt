package com.example.trainingproject.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.core.domain.FetchNewsUseCase
import com.example.trainingproject.core.result.UIState
import com.example.trainingproject.feature.cards.CardUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UIState<List<CardUiModel>>>(UIState.Loading)
    val uiState: StateFlow<UIState<List<CardUiModel>>> get() = _uiState

    init {
        fetchNewsFromApi()
    }

    private fun fetchNewsFromApi() {
        viewModelScope.launch {
            try {
                val news = fetchNewsUseCase()
                _uiState.emit(UIState.Success(news))
            } catch (e: Exception){
                _uiState.emit(UIState.Error("Error Fetching Data"))
            }

        }
    }
}