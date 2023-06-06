package com.example.smart_development.feature_training_session.presentation.new_training_session

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smart_development.feature_training_session.domain.model.Training
import com.example.smart_development.feature_training_session.domain.usecases.TrainingType
import com.example.smart_development.feature_training_session.domain.repository.CreateTraining
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenState
import com.example.smart_development.feature_training_session.domain.usecases.TypeRadioButtonState
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

const val STRENGTH = "STRENGTH"
const val RESISTANCE = "RESISTANCE"
const val HYPERTROPHY = "HYPERTROPHY"

class NewTrainingSessionViewModel(
    private val createTraining: CreateTraining
) : ViewModel() {


    var promptState by mutableStateOf("")
        private set
    var homeRadioButtonSelectedState by mutableStateOf(false)
        private set
    var gymRadioButtonSelectedState by mutableStateOf(false)
        private set
    var pickerState by mutableStateOf(40f)
        private set
    var strengthTrainingSelectedState by mutableStateOf(false)
        private set
    var resistanceTrainingSelectedState by mutableStateOf(false)
        private set
    var hypertrophyTrainingSelectedState by mutableStateOf(false)
        private set

//    private val _trainingState = mutableStateOf(NewTrainingScreenState())
//    val trainingState: State<NewTrainingScreenState> = _trainingState

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


                }
            }

            is NewTrainingScreenEvent.RadioButtonPressed -> {
                when (event.button) {
                    TypeRadioButtonState.GYM_SELECTED -> {
                        homeRadioButtonSelectedState = false
                        gymRadioButtonSelectedState = true
                    }

                    TypeRadioButtonState.HOME_SELECTED -> {
                        homeRadioButtonSelectedState = true
                        gymRadioButtonSelectedState = false
                    }
                }
            }

            is NewTrainingScreenEvent.PickerTextChanged -> {
                pickerState = event.days
            }

            is NewTrainingScreenEvent.TrainingTypeClicked -> {
                when (event.trainingType) {
                    TrainingType.STRENGTH -> {
                        strengthTrainingSelectedState = true
                        resistanceTrainingSelectedState = false
                        hypertrophyTrainingSelectedState = false
                    }

                    TrainingType.RESISTANCE -> {
                        resistanceTrainingSelectedState = true
                        strengthTrainingSelectedState = false
                        hypertrophyTrainingSelectedState = false
                    }

                    TrainingType.HYPERTROPHY -> {
                        hypertrophyTrainingSelectedState = true
                        resistanceTrainingSelectedState = false
                        strengthTrainingSelectedState = false
                    }
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