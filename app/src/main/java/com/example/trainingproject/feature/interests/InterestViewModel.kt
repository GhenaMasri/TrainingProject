package com.example.trainingproject.feature.interests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.core.domain.FetchInterestsUseCase
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
        fetchInterests()
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
}

