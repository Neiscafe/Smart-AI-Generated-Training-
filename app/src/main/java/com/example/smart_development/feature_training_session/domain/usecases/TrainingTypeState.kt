package com.example.smart_development.feature_training_session.domain.usecases

data class TrainingTypeState(
    private val strengthEnabled: Boolean = false,
    private val resistance: Boolean = false,
    private val hypertrophy: Boolean = false
)