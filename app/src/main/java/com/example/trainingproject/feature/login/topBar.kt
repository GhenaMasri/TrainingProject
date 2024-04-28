package com.example.trainingproject.feature.login

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trainingproject.main.theme.TrainingProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopBar(
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "Login")
        },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun LoginTopBarPreview() {
    TrainingProjectTheme {
        LoginTopBar()
    }
}