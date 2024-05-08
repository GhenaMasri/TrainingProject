package com.example.trainingproject.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trainingproject.core.model.Topic

@Entity(
    tableName = "topics",
)

data class TopicEntity (
    @PrimaryKey
    val id: String,
    val name: String,
    val shortDescription: String,
    @ColumnInfo(defaultValue = "")
    val longDescription: String,
    @ColumnInfo(defaultValue = "")
    val url: String,
    @ColumnInfo(defaultValue = "")
    val imageUrl: String,
)
