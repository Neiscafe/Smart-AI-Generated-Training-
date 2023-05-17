package com.example.smart_development.feature_training_session.domain.repository

import com.example.smart_development.feature_training_session.data.repository.Repository
import com.example.smart_development.feature_training_session.domain.model.TrainingSession

class CreateTraining(
    val repository: Repository
){
    suspend operator fun invoke(prompt: String): TrainingSession {
        return repository.createTraining(prompt = prompt)
    }
}
