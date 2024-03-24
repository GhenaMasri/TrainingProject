package com.example.trainingproject.main

import com.example.trainingproject.cards.CardUiModel

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