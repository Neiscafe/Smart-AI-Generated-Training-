package com.example.smart_development.feature_training_session.domain.repository

import com.example.smart_development.feature_training_session.data.repository.Repository
import com.example.smart_development.feature_training_session.domain.model.Training
import kotlinx.coroutines.flow.Flow

class GetTraining(
    private val repository: Repository
){

    operator fun invoke(): Flow<List<Training>> {
        return repository.getTraining()
    }

}