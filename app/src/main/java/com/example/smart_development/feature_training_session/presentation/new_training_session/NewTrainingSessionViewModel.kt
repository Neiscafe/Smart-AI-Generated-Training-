package com.example.smart_development.feature_training_session.presentation.new_training_session

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smart_development.feature_training_session.domain.model.Training
import com.example.smart_development.feature_training_session.domain.repository.CreateTraining
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.TypeRadioButtonState
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NewTrainingSessionViewModel(
    private val createTraining: CreateTraining
) : ViewModel() {

    var trainingState by mutableStateOf<Training?>(null)
        private set
    var promptState by mutableStateOf("")
        private set
    var homeRadioButtonSelectedState by mutableStateOf(false)
        private set
    var gymRadioButtonSelectedState by mutableStateOf(true)
        private set
    var pickerState by mutableStateOf(4f)
        private set
    var trainingTypeSelectedState by mutableStateOf(0)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NewTrainingScreenEvent) {
        when (event) {
            is NewTrainingScreenEvent.PromptTextChanged -> {
                promptState = event.text
            }

            is NewTrainingScreenEvent.DoneButtonClicked -> {
                viewModelScope.launch {
                    if (promptState.isBlank()) {
                        return@launch
                    }
                    val newTraining = createTraining.invoke(prompt = promptState)
                    when (newTraining) {
                        is Training.TrainingSession -> {
                            sendUiEvent(UiEvent.ShowToast(message = "Sucesso na criação do treino!"))
                        }

                        is Training.TrainingError -> {
                            sendUiEvent(UiEvent.ShowToast(message = newTraining.message))
                        }
                    }
                    sendUiEvent(UiEvent.PopBackStack)
                }
            }

            is NewTrainingScreenEvent.RadioButtonPressed -> {
                if (event.button == TypeRadioButtonState.GYM_SELECTED) {
                    homeRadioButtonSelectedState = false
                    gymRadioButtonSelectedState = true
                } else {
                    homeRadioButtonSelectedState = true
                    gymRadioButtonSelectedState = false
                }
            }

            is NewTrainingScreenEvent.PickerTextChanged -> {
                pickerState = event.days
            }

            is NewTrainingScreenEvent.TrainingTypeClicked -> {
                if (event.trainingType.name == "STRENGTH") {
                    trainingTypeSelectedState = 1
                }
                if (event.trainingType.name == "RESISTANCE") {
                    trainingTypeSelectedState = 2
                }
                if (event.trainingType.name == "HYPERTROPHY") {
                    trainingTypeSelectedState = 3
                }
            }
        }
    }


    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}