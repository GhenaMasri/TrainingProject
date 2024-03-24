package com.example.trainingproject.cards

data class CardUiModel(
    val title: String,
    val date: String,
    val description: String,
    val keywords: List<String>
) {
    companion object {
        fun preview() = CardUiModel(
            title = "title",
            date = "date",
            description = "description",
            keywords = emptyList()
        )
    }
}
