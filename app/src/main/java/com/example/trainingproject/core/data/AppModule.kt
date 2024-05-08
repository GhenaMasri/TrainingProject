package com.example.trainingproject.core.data

import com.example.trainingproject.core.domain.FetchInterestsUseCase
import com.example.trainingproject.core.domain.FetchNewsUseCase
import com.example.trainingproject.core.domain.FetchTopicsUseCase
import com.example.trainingproject.core.network.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTopicsRepository(apiService: ApiService): TopicsRepository {
        return TopicsRepository(apiService)
    }

    @Provides
    fun provideFetchInterestsUseCase(topicsRepository: TopicsRepository): FetchInterestsUseCase {
        return FetchInterestsUseCase(topicsRepository)
    }

    @Provides
    fun provideFetchTopicsUseCase(topicsRepository: TopicsRepository): FetchTopicsUseCase {
        return FetchTopicsUseCase(topicsRepository)
    }

    @Provides
    fun provideNewsRepository(
        fetchTopicsUseCase: FetchTopicsUseCase,
        apiService: ApiService
    ): NewsRepository {
        return NewsRepository(apiService,fetchTopicsUseCase)
    }

    @Provides
    fun provideFetchNewsUseCase(newsRepository: NewsRepository): FetchNewsUseCase {
        return FetchNewsUseCase(newsRepository)
    }
}
