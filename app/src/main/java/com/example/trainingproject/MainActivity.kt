package com.example.trainingproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.trainingproject.navigation.MyApp
import com.example.trainingproject.ui.theme.TrainingProjectTheme

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
