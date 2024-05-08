package com.example.trainingproject.core.domain

import com.example.trainingproject.core.data.NewsRepository
import javax.inject.Inject

class InsertNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke() {
        newsRepository.insertNewsToDatabase()
    }
}