package com.example.smart_development.feature_training_session.data.repository

import android.util.Log
import com.example.smart_development.feature_training_session.data.model.Message
import com.example.smart_development.feature_training_session.data.model.PromptModel
import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import com.example.smart_development.feature_training_session.data.network.TrainingService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class RepositoryImpl(
    private val remote: TrainingService,
) : Repository {
    override fun getTraining(): Flow<List<TrainingSession>> {
//        return remote.getTraining()
        return emptyFlow()
    }

    override suspend fun createTraining(prompt: String): TrainingSession {
        val promptModel = PromptModel(
            messages = listOf(
                Message(content = prompt)
            )
        )
        Log.i("RepositoryImpl", "createTraining: CreateTraining success")
        return remote.createTraining(promptModel = promptModel)
    }
}

interface Repository {
    fun getTraining(): Flow<List<TrainingSession>>
    suspend fun createTraining(prompt: String): TrainingSession
}
