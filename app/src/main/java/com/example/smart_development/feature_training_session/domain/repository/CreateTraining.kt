package com.example.smart_development.feature_training_session.domain.repository

import com.example.smart_development.feature_training_session.data.repository.Repository
import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import com.example.smart_development.feature_training_session.domain.util.toPromptModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class CreateTraining(
    private val repository: Repository
){
    suspend operator fun invoke(prompt: String): Flow<TrainingSession> {
        val promptModel = prompt.toPromptModel()
        val response = repository.createTraining(prompt = promptModel)
        return emptyFlow()
    }
}
