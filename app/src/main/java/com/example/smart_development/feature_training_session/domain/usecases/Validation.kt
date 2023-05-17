package com.example.smart_development.feature_training_session.domain.usecases

data class Validation(
    private val sucessfull: Boolean,
    private val message: String? = null
)


