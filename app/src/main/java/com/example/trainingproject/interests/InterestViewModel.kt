package com.example.trainingproject.interests

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltViewModel
class InterestsViewModel @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val topicsRepository: TopicsRepository
) : ViewModel() {

    private val _interestsUiModel = MutableStateFlow<List<InterestsItemUiModel>>(emptyList())
    val interestsUiModel: StateFlow<List<InterestsItemUiModel>> get() = _interestsUiModel

    init {
        fetchInterests()
    }

    private fun fetchInterests() {
        viewModelScope.launch {
            val topics = topicsRepository.getTopics(appContext)
            val uiModels = topics.map {
                InterestsItemUiModel(
                    image = it.imageUrl,
                    topic = it.name,
                    followed = false
                )
            }
            _interestsUiModel.emit(uiModels)
        }
    }
}

