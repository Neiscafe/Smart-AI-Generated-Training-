package com.example.smart_development.feature_training_session.presentation.new_training_session

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smart_development.feature_training_session.domain.repository.CreateTraining
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.TrainingType
import com.example.smart_development.feature_training_session.domain.usecases.TrainingPlace
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

const val STRENGTH = "STRENGTH"
const val RESISTANCE = "RESISTANCE"
const val HYPERTROPHY = "HYPERTROPHY"
const val TAG = "NewTrainingSessionViewModel"

class NewTrainingSessionViewModel(
    private val createTraining: CreateTraining
) : ViewModel() {

    private var promptState by mutableStateOf("")
    var currentlySelectedTrainingPlace: TrainingPlace? by mutableStateOf(null)
    var pickerState by mutableStateOf(40f)
    var currentlySelectedTrainingType: TrainingType? by mutableStateOf(null)

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NewTrainingScreenEvent) {
        when (event) {
            is NewTrainingScreenEvent.PromptTextChanged -> {
                promptState = event.text
            }

            is NewTrainingScreenEvent.DoneButtonClicked -> {
                viewModelScope.launch {
//                    if (promptState.isBlank()) {
//                        return@launch
//                    }
//                    when (val newTraining = createTraining.invoke(prompt = promptState)) {
//                        is Training.TrainingSession -> {
//                            sendUiEvent(UiEvent.ShowToast(message = "Sucesso na criação do treino!"))
//                        }
//                        is Training.TrainingError -> {
//                            sendUiEvent(UiEvent.ShowToast(message = newTraining.message))
//                        }
//                    }
//                    sendUiEvent(UiEvent.PopBackStack)
//                    when()
                    println("a")

                }
            }

            is NewTrainingScreenEvent.TrainingPlaceClicked -> {
                currentlySelectedTrainingPlace = event.trainingPlace
            }

            is NewTrainingScreenEvent.PickerTextChanged -> {
                pickerState = event.days
            }

            is NewTrainingScreenEvent.TrainingTypeClicked -> {
                currentlySelectedTrainingType = event.trainingType
            }

            else -> {}
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}