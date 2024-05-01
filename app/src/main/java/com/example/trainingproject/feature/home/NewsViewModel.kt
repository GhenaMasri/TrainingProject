package com.example.trainingproject.feature.home

import com.example.trainingproject.core.network.retrofit.RetrofitInstance
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.core.domain.FetchNewsUseCase
import com.example.trainingproject.feature.cards.CardUiModel
import com.example.trainingproject.feature.cards.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val fetchNewsUseCase: FetchNewsUseCase
) : ViewModel() {
    private val apiService = RetrofitInstance.apiService
    private val _newsUiModel = MutableStateFlow<List<CardUiModel>>(emptyList())
    val newsUiModel: StateFlow<List<CardUiModel>> get() = _newsUiModel

    init {
        fetchNews()
        //getNewsFromApi()
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

    private fun getNewsFromApi() {
        viewModelScope.launch {
            try {
                val topics = apiService.getNews()
                val uiModels = topics.map {
                    it.toUiModel()
                }
                _newsUiModel.emit(uiModels)
            } catch (e: Exception) {
                Log.e("NewsViewModel", "Error fetching news", e)
            }
        }
    }
}