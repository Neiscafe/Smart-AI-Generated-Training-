package com.example.smart_development.feature_training_session.data.model

sealed class NetworkResponse<out T>() {
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Failure(val error: String) : NetworkResponse<Nothing>()
}

