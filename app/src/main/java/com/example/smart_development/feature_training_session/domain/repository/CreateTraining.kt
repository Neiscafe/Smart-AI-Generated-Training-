package com.example.smart_development.feature_training_session.domain.repository

import android.util.Log
import com.example.smart_development.feature_training_session.data.repository.Repository
import com.example.smart_development.feature_training_session.domain.model.TrainingSession

class CreateTraining(
    private val repository: Repository
){
    suspend operator fun invoke(prompt: String): TrainingSession {
        Log.i("CreateTraining", "invoke: Invoke success")
        return repository.createTraining(prompt = prompt)
    }
}
