package com.example.trainingproject.feature.interests.home

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
import com.example.trainingproject.feature.cards.MainCard
import com.example.trainingproject.main.theme.TrainingProjectTheme


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