package com.example.smart_development.feature_training_session.data.model

data class ErrorResponse(
    val error: Error
)

data class Error(
    val message: String,
    val type: String,
    val param: String? = null,
    val code: String? = null
)