package com.example.smart_development.feature_training_session.domain.usecases

sealed class UiEvent{
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class ShowToast(val message: String): UiEvent()
}
