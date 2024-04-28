package com.example.trainingproject.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.trainingproject.main.navigation.MyApp
import com.example.trainingproject.main.theme.TrainingProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingProjectTheme {
                MyApp()
            }
        }
    }
}
