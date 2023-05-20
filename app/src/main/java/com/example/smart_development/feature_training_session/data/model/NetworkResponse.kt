package com.example.smart_development.feature_training_session.data.model


//data class WrapperResponse(
//    val id: String? = null,
//    val usage: Usage? = null,
//    val choices: List<Choice>? = null,
//    val error: Error? = null
//)

sealed class NetworkResponse<out T> {
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Failure(val message: String) : NetworkResponse<Nothing>()
}