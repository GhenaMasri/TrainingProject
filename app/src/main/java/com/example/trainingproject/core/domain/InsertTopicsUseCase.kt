package com.example.trainingproject.core.domain

import com.example.trainingproject.core.data.TopicsRepository
import javax.inject.Inject

class InsertTopicsUseCase @Inject constructor(
    private val topicsRepository: TopicsRepository
) {
    suspend operator fun invoke(){
        topicsRepository.insertTopicsToDatabase()
    }
}