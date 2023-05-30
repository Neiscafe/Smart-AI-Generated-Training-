package com.example.smart_development.feature_training_session.domain.usecases

import com.example.smart_development.feature_training_session.presentation.new_training_session.NewTrainingSessionViewModel

sealed class NewTrainingScreenEvent{
    data class RadioButtonClicked(val button: TypeRadioButtonState): NewTrainingScreenEvent()
    object DoneButtonClicked: NewTrainingScreenEvent()
    data class PromptTextChanged(val text: String): NewTrainingScreenEvent()
}


