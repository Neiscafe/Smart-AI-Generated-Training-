package com.example.smart_development.feature_training_session.data.repository

import com.example.smart_development.feature_training_session.data.model.TrainingResponse
import com.example.smart_development.feature_training_session.data.model.NetworkResponse
import com.example.smart_development.feature_training_session.domain.model.PromptModel
import com.example.smart_development.feature_training_session.data.network.TrainingService
import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import retrofit2.HttpException
import java.io.IOException

const val TAG = "RepositoryImpl"

class RepositoryImpl(
    private val remote: TrainingService,
) : Repository {
    override fun getTraining(): Flow<List<TrainingSession>> {
//        return remote.getTraining()
        return emptyFlow()
    }

    override suspend fun createTraining(prompt: PromptModel): NetworkResponse<TrainingResponse> {
        return try {
            val response = remote.createTraining(prompt)
            if (response.isSuccessful) {
                NetworkResponse.Success(response.body()!!)
            } else {
                NetworkResponse.Failure(response.message())
            }
        } catch (e: HttpException) {
            NetworkResponse.Failure(e.message())
        } catch (e: IOException) {
            NetworkResponse.Failure(e.message!!)
        }
    }
}

interface Repository {
    fun getTraining(): Flow<List<TrainingSession>>
    suspend fun createTraining(prompt: PromptModel): NetworkResponse<TrainingResponse>
}
