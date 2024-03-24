package com.example.trainingproject.interests

import com.example.trainingproject.R

data class InterestsItemUiModel(
    val image: Int,
    val topic: String,
    val followed: Boolean,
) {
    companion object {
        fun preview() = InterestsItemUiModel(
            image = R.drawable.compose,
            topic = "Compose",
            followed = true
        )
    }
}
