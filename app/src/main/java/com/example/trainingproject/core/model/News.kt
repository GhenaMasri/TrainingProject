package com.example.trainingproject.core.model

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
