@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.trainingproject.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainingproject.interests.Interests
import com.example.trainingproject.mainpage.mainPage
import com.example.trainingproject.savedpage.Saved
import com.example.trainingproject.ui.theme.TrainingProjectTheme


@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(modifier = modifier, bottomBar = {
        myBottomNavBar(navController) }, topBar = { TopBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.ForYou.name,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screens.ForYou.name) {
                mainPage(count = 5)
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

@Preview
@Composable
private fun MyAppPreview(){
    TrainingProjectTheme {
        MyApp(modifier = Modifier)
    }
}