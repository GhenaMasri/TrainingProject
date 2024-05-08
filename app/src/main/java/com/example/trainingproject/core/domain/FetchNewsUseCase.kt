package com.example.trainingproject.core.domain

import com.example.trainingproject.core.data.NewsRepository
import com.example.trainingproject.feature.cards.CardUiModel
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){
   suspend operator fun invoke(): List<CardUiModel> {
       return newsRepository.getNews()
   }
}
