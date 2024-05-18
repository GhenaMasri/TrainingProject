package com.example.trainingproject.feature.cards

import com.example.trainingproject.core.model.News

data class CardUiModel(
    val title: String,
    val date: String,
    val image : String?,
    val description: String,
    val keywords: List<String>,
    val saved: Boolean
) {
    companion object {
        fun preview() = CardUiModel(
            title = "title",
            date = "date",
            image = "",
            description = "description",
            keywords = emptyList(),
            saved = false,
        )
    }
}

fun News.toUiModel() = CardUiModel(
    title = title,
    image = headerImageUrl,
    description = content,
    date = publishDate,
    keywords = topics,
    saved = false,
)
