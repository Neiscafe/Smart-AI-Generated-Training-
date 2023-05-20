package com.example.smart_development.feature_training_session.domain.model

sealed class Training {
    data class TrainingSession(val title: String, val type: String): Training()
    data class TrainingError(val message: String): Training()
}
