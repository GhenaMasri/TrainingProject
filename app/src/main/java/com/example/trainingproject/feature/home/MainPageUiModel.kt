package com.example.trainingproject.feature.home

import com.example.trainingproject.feature.cards.CardUiModel

data class MainPageUiModel(
    val cards: List<CardUiModel>,
) {
    companion object {
        fun preview() = MainPageUiModel(
            cards = listOf(
                CardUiModel.preview(),
                CardUiModel.preview(),
                CardUiModel.preview(),
                CardUiModel.preview(),
            )
        )
    }
}