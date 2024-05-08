package com.example.trainingproject.core.model

import com.example.trainingproject.core.database.model.NewsResourceEntity
import kotlinx.serialization.Serializable

@Serializable
data class News(
    val id: String,
    val title: String,
    val content: String,
    val headerImageUrl: String?,
    val publishDate: String,
    val type: String,
    val topics: List<String>
    )

fun News.asEntity() = NewsResourceEntity(
    id = id,
    title = title,
    content = content,
    headerImageUrl = headerImageUrl,
    publishDate = publishDate,
    type = type,
    topics = topics,
)