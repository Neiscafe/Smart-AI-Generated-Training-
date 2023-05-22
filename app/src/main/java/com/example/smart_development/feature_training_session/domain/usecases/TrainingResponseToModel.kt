package com.example.smart_development.feature_training_session.domain.usecases

import com.example.smart_development.feature_training_session.data.model.NetworkResponse
import com.example.smart_development.feature_training_session.data.model.TrainingResponse
import com.example.smart_development.feature_training_session.domain.model.Training

class TrainingResponseToModel {
    fun execute(response: NetworkResponse<TrainingResponse>): Training {
        return when (response) {
            is NetworkResponse.Success -> {
                Training.TrainingSession(type = "Gym", title = "Name")
            }
            is NetworkResponse.Failure -> {
                Training.TrainingError(
                    message = response.error ?: "An unknown error has ocurred"
                )
            }
        }
    }
}