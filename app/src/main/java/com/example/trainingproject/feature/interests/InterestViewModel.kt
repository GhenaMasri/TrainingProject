package com.example.trainingproject.feature.interests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.core.domain.FetchInterestsUseCase
import com.example.trainingproject.core.result.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    private val fetchInterestsUseCase: FetchInterestsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<List<InterestsItemUiModel>>>(UIState.Loading)
    val uiState: StateFlow<UIState<List<InterestsItemUiModel>>> get() = _uiState

    init {
        fetchInterestsFromAPI()
    }

    private fun fetchInterestsFromAPI() {
        viewModelScope.launch {
            try {
                val topics = fetchInterestsUseCase()
                _uiState.emit(UIState.Success(topics))
            } catch (e: Exception) {
                _uiState.emit(UIState.Error("Error Fetching Data"))
            }
        }
    }
}

