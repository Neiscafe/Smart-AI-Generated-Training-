package com.example.smart_development.feature_training_session.presentation.new_training_session

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smart_development.feature_training_session.domain.model.Training
import com.example.smart_development.feature_training_session.domain.repository.CreateTraining
import com.example.smart_development.feature_training_session.domain.usecases.NewTrainingScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NewTrainingSessionViewModel(
    private val createTraining: CreateTraining
) : ViewModel() {

    var training by mutableStateOf<Training?>(null)
        private set
    var prompt by mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: NewTrainingScreenEvent) {
        when (event) {
            is NewTrainingScreenEvent.PromptTextChanged -> {
                prompt = event.text
            }

            is NewTrainingScreenEvent.DoneButtonClicked -> {
                viewModelScope.launch {
                    if (prompt.isBlank()) {
                        return@launch
                    }
                    val newTraining = createTraining.invoke(prompt = prompt)
                    when (newTraining){
                        is Training.TrainingSession->{
                            sendUiEvent(UiEvent.ShowToast(message = "Sucesso na criação do treino!"))
                        }
                        is Training.TrainingError->{
                            sendUiEvent(UiEvent.ShowToast(message = newTraining.message))
                        }
                    }
                    sendUiEvent(UiEvent.PopBackStack)
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