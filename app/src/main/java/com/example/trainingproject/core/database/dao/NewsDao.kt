package com.example.trainingproject.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.trainingproject.core.database.model.NewsResourceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM news_resources")
    fun getNewsEntities() : Flow<List<NewsResourceEntity>>


    @Upsert
    suspend fun upsertNews(entities: List<NewsResourceEntity>)
}