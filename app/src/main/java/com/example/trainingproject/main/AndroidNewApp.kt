package com.example.trainingproject.main

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.example.trainingproject.core.data.NewsRepository
import com.example.trainingproject.core.data.TopicsRepository
import com.example.trainingproject.core.domain.FetchInterestsUseCase
import com.example.trainingproject.core.domain.FetchNewsUseCase
import com.example.trainingproject.core.domain.FetchTopicsUseCase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AndroidNewApp : Application() {
    @Inject
    lateinit var topicsRepository: TopicsRepository
    @Inject
    lateinit var fetchInterestsUseCase: FetchInterestsUseCase
    @Inject
    lateinit var newsRepository: NewsRepository
    @Inject
    lateinit var fetchNewsUseCase: FetchNewsUseCase
    @Inject
    lateinit var fetchTopicsUseCase: FetchTopicsUseCase
    override fun onCreate() {
        super.onCreate()
        topicsRepository = TopicsRepository(this@AndroidNewApp)
        fetchInterestsUseCase = FetchInterestsUseCase(topicsRepository)
        fetchTopicsUseCase = FetchTopicsUseCase(topicsRepository)
        newsRepository = NewsRepository(appContext = this@AndroidNewApp, fetchTopicsUseCase = fetchTopicsUseCase)
        fetchNewsUseCase = FetchNewsUseCase(newsRepository)
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