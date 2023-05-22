package com.example.smart_development.feature_training_session.domain.repository

import com.example.smart_development.feature_training_session.data.repository.Repository
import com.example.smart_development.feature_training_session.domain.model.Training
import com.example.smart_development.feature_training_session.domain.usecases.TrainingResponseToModel
import com.example.smart_development.feature_training_session.domain.util.toPromptModel

class CreateTraining(
    private val repository: Repository
){
    suspend operator fun invoke(prompt: String): Training {
        val promptModel = prompt.toPromptModel()
        val response = repository.createTraining(prompt = promptModel)
        return TrainingResponseToModel().execute(response)
    }
}
