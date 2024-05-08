package com.example.trainingproject.core.data

import android.util.Log
import com.example.trainingproject.core.network.retrofit.ApiService
import com.example.trainingproject.feature.interests.InterestsItemUiModel
import com.example.trainingproject.feature.interests.toUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

class TopicsRepository @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getTopics(): List<InterestsItemUiModel> {
        return withContext(Dispatchers.IO) {
            try {
                val topics = apiService.getTopics()
                val uiModels = topics.map {
                    it.toUiModel()
                }
                uiModels
            } catch (e: Exception) {
                Log.e("TopicsRepository", "Error fetching topics", e)
                emptyList()
            }
        }
    }

    suspend fun getTopicsMap(): Map<String, String> {
        val topics = apiService.getTopics()
        return topics.associateBy({ it.id }, { it.name })
    }
}
