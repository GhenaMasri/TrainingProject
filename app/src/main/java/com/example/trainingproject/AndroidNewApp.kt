package com.example.trainingproject

import android.app.Application
import com.example.trainingproject.interests.TopicsRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidNewApp : Application() {
    lateinit var topicsRepository: TopicsRepository
        private set

    override fun onCreate() {
        super.onCreate()
        topicsRepository = TopicsRepository()

    }
}

