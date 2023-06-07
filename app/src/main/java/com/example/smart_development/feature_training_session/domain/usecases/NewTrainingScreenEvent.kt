package com.example.smart_development.feature_training_session.domain.usecases

sealed class NewTrainingScreenEvent{
    data class TrainingTypeClicked(val trainingType: TrainingType): NewTrainingScreenEvent()
    data class TrainingPlaceClicked(val trainingPlace: TrainingPlace): NewTrainingScreenEvent()
    data class PickerTextChanged(val days: Float): NewTrainingScreenEvent()
    object DoneButtonClicked: NewTrainingScreenEvent()
    data class PromptTextChanged(val text: String): NewTrainingScreenEvent()
}


