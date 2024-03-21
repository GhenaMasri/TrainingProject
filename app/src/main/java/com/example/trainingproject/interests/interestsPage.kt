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
data class InterestsUiModel(
    val items: List<InterestsItemUiModel>,
) {
    companion object {
        fun preview() = InterestsUiModel(
            listOf(
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
            )
        )
    }
}

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
fun InterestsPreview() {
    Interests(uiModel = InterestsUiModel.preview())
}