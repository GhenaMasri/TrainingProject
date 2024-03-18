package com.example.trainingproject.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingproject.cards.CardUiModel
import com.example.trainingproject.cards.MainCard
import com.example.trainingproject.ui.theme.TrainingProjectTheme

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

@Composable
fun MainPage(modifier: Modifier = Modifier, uiModel: MainPageUiModel) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {
        items(uiModel.cards) { uiModel ->
            MainCard(uiModel = uiModel)
        }

    }
}

@Preview
@Composable
private fun MainPagePreview() {
    TrainingProjectTheme {
        MainPage(uiModel = MainPageUiModel.preview())
    }
}