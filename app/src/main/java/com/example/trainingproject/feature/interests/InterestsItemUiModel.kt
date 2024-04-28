package com.example.trainingproject.feature.interests

import com.example.trainingproject.core.model.Topic

data class InterestsItemUiModel(
    val image: String,
    val topic: String,
    val followed: Boolean,
) {
    companion object {
        fun preview() = InterestsItemUiModel(
            image = "https://firebasestorage.googleapis.com/v0/b/trainingproject-c43e7.appspot.com/o/ic_topic_Compose.svg?alt=media&token=13135378-eaef-481d-ae9b-f6f80d01b797" ,
            topic = "Compose",
            followed = false
        )
    }
}
fun Topic.toUiModel() =
    InterestsItemUiModel(
        image = imageUrl,
        topic = name,
        followed = false
    )