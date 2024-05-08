package com.example.trainingproject.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.trainingproject.core.database.model.TopicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao {

    @Query("SELECT * FROM topics")
    fun getTopicEntities() : Flow<List<TopicEntity>>

    @Upsert
    suspend fun upsertTopics(entities: List<TopicEntity>)
}