package com.example.trainingproject.interests

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