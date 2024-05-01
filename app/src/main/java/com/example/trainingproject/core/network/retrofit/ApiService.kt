package com.example.trainingproject.core.network.retrofit

import com.example.trainingproject.core.model.News
import com.example.trainingproject.core.model.Topic
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    suspend fun getNews(): List<News>

    @GET("topics")
    suspend fun getTopics(): List<Topic>
}