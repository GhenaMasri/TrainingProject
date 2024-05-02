package com.example.trainingproject.feature.interests

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.core.domain.FetchInterestsUseCase
import com.example.trainingproject.core.network.retrofit.RetrofitInstance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    private val fetchInterestsUseCase: FetchInterestsUseCase
) : ViewModel() {

    private val _interestsUiModel = MutableStateFlow<List<InterestsItemUiModel>>(emptyList())
    val interestsUiModel: StateFlow<List<InterestsItemUiModel>> get() = _interestsUiModel
    private val apiService = RetrofitInstance.apiService

    init {
        //fetchInterests()
        fetchInterestsFromAPI()
    }

    private fun fetchInterests() {
        viewModelScope.launch {
            val topics = fetchInterestsUseCase()
            val uiModels = topics.map {
                it.toUiModel()
            }
            _interestsUiModel.emit(uiModels)
        }
    }

    private fun fetchInterestsFromAPI() {
        viewModelScope.launch {
            try {
                val topics = apiService.getTopics()
                val uiModels = topics.map {
                    it.toUiModel()
                }
                _interestsUiModel.emit(uiModels)

            } catch (e: Exception) {
                Log.e("InterestViewModel", "Error fetching topics", e)
            }
        }
    }
}

