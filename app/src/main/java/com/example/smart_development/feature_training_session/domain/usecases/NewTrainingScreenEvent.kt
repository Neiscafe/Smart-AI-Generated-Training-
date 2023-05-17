package com.example.smart_development.feature_training_session.domain.usecases

sealed class NewTrainingScreenEvent{
    object DoneButtonClicked: NewTrainingScreenEvent()
    data class PromptTextChanged(val text: String): NewTrainingScreenEvent()
}
