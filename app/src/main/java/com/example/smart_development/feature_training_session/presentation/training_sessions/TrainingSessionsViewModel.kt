package com.example.smart_development.feature_training_session.presentation.training_sessions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smart_development.feature_training_session.domain.model.Training
import com.example.smart_development.feature_training_session.domain.repository.GetTraining
import com.example.smart_development.feature_training_session.domain.usecases.MainScreenEvent
import com.example.smart_development.feature_training_session.domain.usecases.UiEvent
import com.example.smart_development.feature_training_session.domain.util.Routes
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class TrainingSessionsViewModel(
    private val getTraining: GetTraining,
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getAllTrainings(): Flow<List<Training>> {
        return getTraining.invoke()
    }

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.CreateButtonClicked -> sendUiEvent(UiEvent.Navigate(Routes.NEW_TRAINING_SCREEN))
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}