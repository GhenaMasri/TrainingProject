package com.example.trainingproject.core.data

import com.example.trainingproject.core.database.AppDatabase
import com.example.trainingproject.core.database.model.asTopic
import com.example.trainingproject.core.model.asEntity
import com.example.trainingproject.core.network.retrofit.ApiService
import com.example.trainingproject.feature.interests.InterestsItemUiModel
import com.example.trainingproject.feature.interests.toUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopicsRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {
    suspend fun getTopics(): List<InterestsItemUiModel> {
        return withContext(Dispatchers.IO) {

            val topics = apiService.getTopics()
            val uiModels = topics.map {
                it.toUiModel()
            }
            uiModels

        }
    }

    suspend fun getTopicsMap(): Map<String, String> {
        val topics = apiService.getTopics()
        return topics.associateBy({ it.id }, { it.name })
    }

    suspend fun insertTopicsToDatabase() {
        withContext(Dispatchers.IO) {
            val topics = apiService.getTopics()
            val topicEntities = topics.map {
                it.asEntity()
            }
            appDatabase.topicDao().upsertTopics(topicEntities)
        }
    }

    suspend fun getTopicsEntities(): List<InterestsItemUiModel> {
        val topics = appDatabase.topicDao().getTopicEntities().first()
        return topics.map { it.asTopic().toUiModel() }
    }
}
