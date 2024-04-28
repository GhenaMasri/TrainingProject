package com.example.trainingproject.core.data

import android.content.Context
import com.example.trainingproject.core.model.Topic
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class TopicsRepository @Inject constructor(
    @ApplicationContext private val appContext: Context,
) {
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getTopics(): List<Topic> {
        val json = Json { ignoreUnknownKeys = true }

        return withContext(Dispatchers.IO) {
            appContext.assets.open("topics.json").use { inputStream ->
                json.decodeFromStream(inputStream)
            }
        }
    }
}
