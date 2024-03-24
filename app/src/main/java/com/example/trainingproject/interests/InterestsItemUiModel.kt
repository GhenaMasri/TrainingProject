package com.example.trainingproject.interests

import androidx.annotation.DrawableRes
import com.example.trainingproject.R

data class InterestsItemUiModel(
    @DrawableRes val image: Int,
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
