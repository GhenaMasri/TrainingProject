package com.example.trainingproject.feature.interests

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
import com.example.trainingproject.main.theme.TrainingProjectTheme

@Composable
fun Interests(modifier: Modifier = Modifier,
              viewModel: InterestsViewModel = hiltViewModel()) {
    val uiModel by viewModel.interestsUiModel.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {
        items(uiModel) { item ->
            InterestsItem(uiModel = item)
        }
    }
}

@Preview
@Composable
private fun InterestsPreview() {
    TrainingProjectTheme {
        Interests()
    }
}

