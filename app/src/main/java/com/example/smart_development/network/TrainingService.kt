package com.example.smart_development.network

import com.example.smart_development.model.TrainingSession
import retrofit2.http.GET
import retrofit2.http.Query

interface TrainingService {
    @GET()
    fun getCompletion(
        @Query(value = "model") model: String = "gpt-3.5-turbo",
        @Query(value = "prompt") prompt: String
    ): TrainingSession
}