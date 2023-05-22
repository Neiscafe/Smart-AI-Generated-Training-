package com.example.smart_development.feature_training_session.data.repository

import com.example.smart_development.feature_training_session.data.model.NetworkResponse
import com.example.smart_development.feature_training_session.data.model.TrainingResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class HandleNetworkResponse {
    fun execute(response: Response<TrainingResponse>): NetworkResponse<TrainingResponse> {
        return try {
            if (response.isSuccessful) {
                NetworkResponse.Success(data = response.body()!!)
            } else {
                NetworkResponse.Failure(error = response.message())
            }
        } catch (e: HttpException) {
            NetworkResponse.Failure(error = e.message())
        } catch (e: IOException) {
            NetworkResponse.Failure(error = e.message!!)
        }
    }
}