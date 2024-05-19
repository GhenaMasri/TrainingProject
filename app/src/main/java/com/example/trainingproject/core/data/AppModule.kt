package com.example.trainingproject.core.data

import android.content.Context
import androidx.room.Room
import com.example.trainingproject.core.database.AppDatabase
import com.example.trainingproject.core.domain.FetchInterestsUseCase
import com.example.trainingproject.core.domain.FetchNewsFromDBUseCase
import com.example.trainingproject.core.domain.FetchNewsUseCase
import com.example.trainingproject.core.domain.FetchTopicsFromDBUseCase
import com.example.trainingproject.core.domain.FetchTopicsUseCase
import com.example.trainingproject.core.domain.InsertNewsUseCase
import com.example.trainingproject.core.domain.InsertTopicsUseCase
import com.example.trainingproject.core.network.retrofit.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "android_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTopicsRepository(
        apiService: ApiService,
        appDatabase: AppDatabase
    ): TopicsRepository {
        return TopicsRepository(apiService, appDatabase)
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
    fun provideFetchTopicsFromDBUseCase(topicsRepository: TopicsRepository): FetchTopicsFromDBUseCase {
        return FetchTopicsFromDBUseCase(topicsRepository)
    }

    @Provides
    fun provideNewsRepository(
        fetchTopicsUseCase: FetchTopicsUseCase,
        apiService: ApiService,
        appDatabase: AppDatabase
    ): NewsRepository {
        return NewsRepository(apiService, fetchTopicsUseCase, appDatabase)
    }

    @Provides
    fun provideFetchNewsUseCase(newsRepository: NewsRepository): FetchNewsUseCase {
        return FetchNewsUseCase(newsRepository)
    }

    @Provides
    fun provideInsertNewsUseCase(newsRepository: NewsRepository): InsertNewsUseCase {
        return InsertNewsUseCase(newsRepository)
    }

    @Provides
    fun provideFetchNewsFromDBUseCase(newsRepository: NewsRepository): FetchNewsFromDBUseCase {
        return FetchNewsFromDBUseCase(newsRepository)
    }

    @Provides
    fun provideInsertTopicsUseCase(topicsRepository: TopicsRepository): InsertTopicsUseCase {
        return InsertTopicsUseCase(topicsRepository)
    }

}
