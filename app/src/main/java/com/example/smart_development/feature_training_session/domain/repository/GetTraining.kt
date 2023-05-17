package com.example.smart_development.feature_training_session.domain.repository

import androidx.lifecycle.ViewModel
import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import com.example.smart_development.feature_training_session.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetTraining(
    private val repository: Repository
){

    operator fun invoke(): Flow<List<TrainingSession>> {
        return repository.getTraining()
    }

}