package com.example.trainingproject.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.trainingproject.core.result.UIState
import com.example.trainingproject.feature.cards.CardUiModel
import com.example.trainingproject.feature.cards.MainCard
import com.example.trainingproject.feature.common.ErrorMessage
import com.example.trainingproject.feature.common.ProgressIndicator
import com.example.trainingproject.main.theme.TrainingProjectTheme


@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState) {
        is UIState.Error -> {
            ErrorMessage(modifier = modifier, message = (uiState as UIState.Error).message)
        }

        UIState.Loading -> {
            ProgressIndicator(modifier = modifier)
        }

        is UIState.Success -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 4.dp)
            ) {
                items((uiState as UIState.Success<List<CardUiModel>>).data) { card ->
                    MainCard(uiModel = card)
                }

            }
        }
    }

}

@Preview
@Composable
private fun MainPagePreview() {
    TrainingProjectTheme {
        MainPage()
    }
}