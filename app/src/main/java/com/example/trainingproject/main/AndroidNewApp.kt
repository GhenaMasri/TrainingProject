package com.example.trainingproject.main

import android.app.Application
import androidx.room.Room
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.example.trainingproject.core.data.TopicsRepository
import com.example.trainingproject.core.database.AppDatabase
import com.example.trainingproject.core.domain.InsertTopicsUseCase
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class AndroidNewApp : Application() {
    @Inject
    lateinit var insertTopicsUseCase: InsertTopicsUseCase

    @Inject
    lateinit var topicsRepository: TopicsRepository
    override fun onCreate() {
        super.onCreate()
        insertToDbOnStartup()
        setupImageLoader()
    }

    private fun setupImageLoader() {
        val imageLoader = ImageLoader.Builder(this@AndroidNewApp)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
        Coil.setImageLoader(imageLoader)
    }
    private fun insertToDbOnStartup() {
        CoroutineScope(Dispatchers.IO).launch {
            InsertTopicsUseCase(topicsRepository)
        }
    }
}