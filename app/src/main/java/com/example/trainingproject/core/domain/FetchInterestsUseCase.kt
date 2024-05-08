package com.example.trainingproject.core.domain

import com.example.trainingproject.core.data.TopicsRepository
import com.example.trainingproject.feature.interests.InterestsItemUiModel
import javax.inject.Inject

class FetchInterestsUseCase @Inject constructor(
    private val interestRepository: TopicsRepository) {

    suspend operator fun invoke(): List<InterestsItemUiModel>{
        return interestRepository.getTopics()
    }
}
