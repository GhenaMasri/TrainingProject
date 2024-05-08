package com.example.trainingproject.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.trainingproject.core.database.model.TopicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TopicDao {

    @Query("SELECT * FROM topics")
    fun getTopicEntities() : Flow<List<TopicEntity>>

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun upsertTopics(entities: List<TopicEntity>)
}