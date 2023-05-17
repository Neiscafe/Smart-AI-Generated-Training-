package com.example.smart_development.feature_training_session.data.model

class TrainingResponse(
    val id: String,
    val usage: Usage,
    val choices: List<Choice>
) {
}