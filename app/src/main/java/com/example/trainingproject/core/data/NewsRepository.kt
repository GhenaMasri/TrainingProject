package com.example.trainingproject.core.data

import android.util.Log
import com.example.trainingproject.core.database.AppDatabase
import com.example.trainingproject.core.domain.FetchTopicsUseCase
import com.example.trainingproject.core.model.asEntity
import com.example.trainingproject.core.network.retrofit.ApiService
import com.example.trainingproject.feature.cards.CardUiModel
import com.example.trainingproject.feature.cards.toUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: ApiService,
    private val fetchTopicsUseCase: FetchTopicsUseCase,
    private val appDatabase: AppDatabase
) {
    suspend fun getNews(): List<CardUiModel> {
        return withContext(Dispatchers.IO) {
            try {
                val news = apiService.getNews()
                val topicsMap: Map<String, String> = fetchTopicsUseCase()
                val uiModels = news.map {
                    it.toUiModel()
                }.map { new -> new.copy(keywords = new.keywords.map { topicsMap[it] ?: "" }) }
                uiModels
            } catch (e: Exception) {
                Log.e("NewsRepository", "Error fetching news", e)
                emptyList()
            }
        }
    }

    suspend fun insertNewsToDatabase() {
        withContext(Dispatchers.IO) {
            val news = apiService.getNews()
            val newsEntities = news.map {
                it.asEntity()
            }
            appDatabase.newsResourceDao().upsertNews(newsEntities)
        }
    }
}

