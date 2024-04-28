package com.example.trainingproject.main

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.example.trainingproject.core.data.TopicsRepository
import com.example.trainingproject.core.domain.FetchInterestsUseCase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AndroidNewApp : Application() {
    @Inject
    lateinit var topicsRepository: TopicsRepository
    @Inject
    lateinit var fetchInterestsUseCase: FetchInterestsUseCase
    override fun onCreate() {
        super.onCreate()
        topicsRepository = TopicsRepository(this@AndroidNewApp)
        fetchInterestsUseCase = FetchInterestsUseCase(topicsRepository)
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