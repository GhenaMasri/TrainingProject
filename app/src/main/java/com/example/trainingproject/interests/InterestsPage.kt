package com.example.trainingproject.interests

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import com.example.trainingproject.ui.theme.TrainingProjectTheme

@Composable
fun Interests(modifier: Modifier = Modifier, uiModel: InterestsUiModel) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {
        items(uiModel.items) { item ->
            InterestsItem(uiModel = item)
        }
    }
}

@Preview
@Composable
private fun InterestsPreview() {
    TrainingProjectTheme() {
        Interests(uiModel = InterestsUiModel.preview())
    }
}
