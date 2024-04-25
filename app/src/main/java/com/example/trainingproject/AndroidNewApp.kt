package com.example.trainingproject

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.example.trainingproject.interests.TopicsRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AndroidNewApp : Application() {
    @Inject
    lateinit var topicsRepository: TopicsRepository

    override fun onCreate() {
        super.onCreate()
        topicsRepository = TopicsRepository()
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

}