package com.example.smart_development.feature_training_session.data.network

import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

const val MODEL = "gpt-3.5-turbo-0301"
interface TrainingService {
    @GET
    fun getTraining(): Flow<List<TrainingSession>>

    @GET
    suspend fun createTraining(
        @Query(value = "model") model: String = MODEL,
        @Query(value = "prompt") prompt: String
    ): TrainingSession
}