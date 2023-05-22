package com.example.smart_development.feature_training_session.data.repository

import com.example.smart_development.feature_training_session.data.model.NetworkResponse
import com.example.smart_development.feature_training_session.data.model.TrainingResponse
import com.example.smart_development.feature_training_session.data.network.TrainingService
import com.example.smart_development.feature_training_session.domain.model.PromptModel
import com.example.smart_development.feature_training_session.domain.model.Training
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

const val TAG = "RepositoryImpl"

class RepositoryImpl(
    private val remote: TrainingService,
) : Repository {
    override fun getTraining(): Flow<List<Training>> {
        return emptyFlow()
    }

    override suspend fun createTraining(prompt: PromptModel): NetworkResponse<TrainingResponse> {
        return HandleNetworkResponse().execute(remote.createTraining(promptModel = prompt))
    }
}

interface Repository {
    fun getTraining(): Flow<List<Training>>
    suspend fun createTraining(prompt: PromptModel): NetworkResponse<TrainingResponse>
}
