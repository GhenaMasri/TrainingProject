package com.example.trainingproject.mainpage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainPage(modifier: Modifier = Modifier){
    Scaffold(modifier = modifier, bottomBar = {}
    ) {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)){}
    }
}