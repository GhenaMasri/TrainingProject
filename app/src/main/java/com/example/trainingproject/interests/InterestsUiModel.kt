package com.example.trainingproject.interests

data class InterestsUiModel(
    val items: List<InterestsItemUiModel>,
) {
    companion object {
        fun preview() = InterestsUiModel(
            listOf(
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
                InterestsItemUiModel.preview(),
            )
        )
    }
}
