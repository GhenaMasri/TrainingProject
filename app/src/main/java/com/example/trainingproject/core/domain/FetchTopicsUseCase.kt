package com.example.trainingproject.core.domain

import com.example.trainingproject.core.data.TopicsRepository
import javax.inject.Inject

class FetchTopicsUseCase @Inject constructor(
    private val interestRepository: TopicsRepository
) {
    suspend operator fun invoke(): Map<String, String> {
        return interestRepository.getTopicsMap()
    }
}