package com.example.trainingproject.core.model

import com.example.trainingproject.core.database.model.TopicEntity
import kotlinx.serialization.Serializable
@Serializable
data class Topic(
    val id: String,
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val imageUrl: String,
    val url: String
)

fun Topic.asEntity() = TopicEntity(
    id = id,
    name = name,
    shortDescription = shortDescription,
    longDescription = longDescription,
    url = url,
    imageUrl = imageUrl,
)