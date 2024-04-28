package com.example.trainingproject.core.data

import android.content.Context
import com.example.trainingproject.core.model.News
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class NewsRepository @Inject constructor(
    @ApplicationContext private val appContext : Context
) {
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getNews() : List<News>{
        val json = Json { ignoreUnknownKeys = true }

        return withContext(Dispatchers.IO){
            appContext.assets.open("news.json").use {inputStream ->
                json.decodeFromStream(inputStream)
            }
        }
    }
}