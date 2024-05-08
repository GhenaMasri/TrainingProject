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

    init {
        fetchInterestsFromAPI()
    }

    private fun fetchInterestsFromAPI() {
        viewModelScope.launch {
            val topics = fetchInterestsUseCase()
            _interestsUiModel.emit(topics)
        }
    }
}
