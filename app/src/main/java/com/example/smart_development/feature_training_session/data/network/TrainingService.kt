package com.example.smart_development.feature_training_session.data.network

import com.example.smart_development.feature_training_session.data.model.ErrorResponse
import com.example.smart_development.feature_training_session.data.model.NetworkResponse
import com.example.smart_development.feature_training_session.data.model.TrainingResponse
import com.example.smart_development.feature_training_session.domain.model.PromptModel
import com.example.smart_development.feature_training_session.domain.model.Training
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TrainingService {
    @GET
    fun getTraining(): Flow<List<Training>>

    @POST("v1/chat/completions")
    suspend fun createTraining(@Body promptModel: PromptModel): Response<TrainingResponse>
}