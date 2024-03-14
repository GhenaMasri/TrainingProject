package com.example.trainingproject.mainpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingproject.cards.MainCard
import com.example.trainingproject.navigation.TopBar
import com.example.trainingproject.navigation.myBottomNavBar
import com.example.trainingproject.ui.theme.TrainingProjectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainPage(modifier: Modifier = Modifier,count : Int){
    Scaffold(modifier = modifier, bottomBar = { myBottomNavBar()}, topBar = {TopBar()}
    ) {paddingValues ->
        LazyColumn(modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
        ){
           items(count){
               item -> MainCard()
           }
        }
    }
}

@Preview
@Composable
private fun mainPagePreview(){
    TrainingProjectTheme {
        mainPage(modifier = Modifier, 5)
    }
}