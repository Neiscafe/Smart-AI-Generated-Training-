package com.example.smart_development.feature_training_session.domain.usecases

sealed class NewTrainingScreenEvent{
    data class RadioButtonPressed(val button: TypeRadioButtonState): NewTrainingScreenEvent()
    data class PickerTextChanged(val days: Int): NewTrainingScreenEvent()
    object DoneButtonClicked: NewTrainingScreenEvent()
    data class PromptTextChanged(val text: String): NewTrainingScreenEvent()
}


