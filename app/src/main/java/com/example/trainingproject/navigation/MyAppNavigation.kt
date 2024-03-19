@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.trainingproject.navigation

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainingproject.interests.Interests
import com.example.trainingproject.main.MainPage
import com.example.trainingproject.main.MainPageUiModel
import com.example.trainingproject.saved.Saved
import com.example.trainingproject.ui.theme.TrainingProjectTheme


@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val linear = Brush.linearGradient(
        listOf(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.colorScheme.surfaceVariant,
            MaterialTheme.colorScheme.primaryContainer,
        )
    )

    Box(
        modifier = modifier
            .background(linear)
    ) {
        Scaffold(
            modifier = Modifier,
            containerColor = Color.Transparent,
            bottomBar = {
                MyBottomNavBar(navController)
            },
            topBar = { TopBar(navController) },
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Screens.ForYou.name,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(route = Screens.ForYou.name) {
                    MainPage(uiModel = MainPageUiModel.preview())
                }
                composable(route = Screens.Saved.name) {
                    Saved()
                }
                composable(route = Screens.Interests.name) {
                    Interests()
                }
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun MyAppPreview() {
    TrainingProjectTheme {
        MyApp(modifier = Modifier)
    }
}