package com.example.trainingproject.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.trainingproject.core.database.dao.NewsDao
import com.example.trainingproject.core.database.dao.TopicDao
import com.example.trainingproject.core.database.model.NewsResourceEntity
import com.example.trainingproject.core.database.model.TopicEntity

@Database(
    entities = [
        NewsResourceEntity::class,
        TopicEntity::class,
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDao
    abstract fun newsResourceDao(): NewsDao
}