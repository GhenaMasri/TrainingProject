package com.example.trainingproject.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.core.domain.FetchNewsUseCase
import com.example.trainingproject.feature.cards.CardUiModel
import com.example.trainingproject.feature.cards.toUiModel
import com.example.trainingproject.feature.interests.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
) : ViewModel(){

    private val _newsUiModel = MutableStateFlow<List<CardUiModel>>(emptyList())
    val newsUiModel : StateFlow<List<CardUiModel>> get() = _newsUiModel

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            val topics = fetchNewsUseCase()
            val uiModels = topics.map {
                it.toUiModel()
            }
            _newsUiModel.emit(uiModels)
        }
    }
}