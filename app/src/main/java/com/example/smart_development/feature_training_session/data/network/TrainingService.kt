package com.example.smart_development.feature_training_session.data.network

import com.example.smart_development.feature_training_session.data.model.PromptModel
import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TrainingService {
    @GET
    fun getTraining(): Flow<List<TrainingSession>>

    @POST("v1/chat/completions")
    suspend fun createTraining(@Body promptModel: PromptModel): TrainingSession
}