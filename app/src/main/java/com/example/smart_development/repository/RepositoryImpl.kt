package com.example.smart_development.repository

import com.example.smart_development.model.TrainingSession
import com.example.smart_development.network.TrainingService
import com.example.smart_development.util.toFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(
    private val remote: TrainingService
) : Repository {
    override suspend fun getTraining(prompt: String): Flow<TrainingSession> {
        return remote.getCompletion(prompt = prompt).toFlow()
    }
}

interface Repository {
    suspend fun getTraining(prompt: String): Flow<TrainingSession>
}
