package com.example.trainingproject.core.domain

import com.example.trainingproject.core.data.NewsRepository
import com.example.trainingproject.core.model.News
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
){
   suspend operator fun invoke(): List<News>{
       return newsRepository.getNews()
   }
}
