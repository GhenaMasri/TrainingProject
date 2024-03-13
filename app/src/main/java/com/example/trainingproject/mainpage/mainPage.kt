package com.example.trainingproject.mainpage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trainingproject.cards.MainCard
import com.example.trainingproject.navigation.myBottomNavBar
import com.example.trainingproject.ui.theme.TrainingProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainPage(modifier: Modifier = Modifier){
    Scaffold(modifier = modifier, bottomBar = { myBottomNavBar()}
    ) {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)){
           MainCard()
        }
    }
}

@Preview
@Composable
private fun mainPagePreview(){
    TrainingProjectTheme {
        mainPage()
    }
}