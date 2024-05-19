package com.example.trainingproject.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trainingproject.core.model.News

@Entity(
    tableName = "news_resources",
)
data class NewsResourceEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val content: String,
    @ColumnInfo(name = "header_image_url")
    val headerImageUrl: String?,
    @ColumnInfo(name = "publish_date")
    val publishDate: String,
    val type: String,
    val topics: List<String>
)

fun NewsResourceEntity.asNews() = News(
    id = id,
    title = title,
    content = content,
    headerImageUrl = headerImageUrl,
    publishDate = publishDate,
    type = type,
    topics = topics,
)