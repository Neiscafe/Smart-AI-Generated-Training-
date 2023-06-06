package com.example.smart_development.feature_training_session.domain.usecases

data class NewTrainingScreenState(
    val trainingDays: TrainingDaysState = TrainingDaysState(),
    val trainingPlace: TrainingPlaceState? = null,
    val trainingType: TrainingTypeState? = null)
