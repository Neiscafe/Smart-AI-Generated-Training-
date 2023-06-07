package com.example.smart_development.feature_training_session.domain.usecases

enum class TrainingPlace {
    HOME_SELECTED {
        override val place = "Home"
    },
    GYM_SELECTED {
        override val place = "Gym"
    };

    abstract val place: String
}