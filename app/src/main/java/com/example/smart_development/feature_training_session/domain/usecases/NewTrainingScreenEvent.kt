package com.example.smart_development.feature_training_session.domain.usecases

import com.example.smart_development.feature_training_session.domain.model.training_types.TrainingType

sealed class NewTrainingScreenEvent{
    data class TrainingTypeClicked(val trainingType: TrainingType): NewTrainingScreenEvent()
    data class RadioButtonPressed(val button: TypeRadioButtonState): NewTrainingScreenEvent()
    data class PickerTextChanged(val days: Float): NewTrainingScreenEvent()
    object DoneButtonClicked: NewTrainingScreenEvent()
    data class PromptTextChanged(val text: String): NewTrainingScreenEvent()
}


