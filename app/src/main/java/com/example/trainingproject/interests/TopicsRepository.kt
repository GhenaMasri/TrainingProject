package com.example.trainingproject.interests

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject

class TopicsRepository @Inject constructor() {
    @OptIn(ExperimentalSerializationApi::class)
    suspend infix fun getTopics(appContext: Context): List<Topic> {
        val json = Json { ignoreUnknownKeys = true }

        return withContext(Dispatchers.IO) {
            appContext.assets.open("topics.json").use { inputStream ->
                json.decodeFromStream(inputStream)
            }
        }
    }
}
