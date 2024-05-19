package com.example.trainingproject.core.data.util

// NetworkUtilsModule.kt

import android.content.Context
import com.example.trainingproject.core.data.util.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkUtilsModule {

    @Singleton
    @Provides
    fun provideIsOnline(@ApplicationContext context: Context): Boolean {
        return NetworkUtils.isOnline(context)
    }
}
