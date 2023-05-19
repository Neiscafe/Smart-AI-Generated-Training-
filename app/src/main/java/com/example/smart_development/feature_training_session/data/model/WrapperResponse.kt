package com.example.smart_development.feature_training_session.data.model


//data class WrapperResponse(val success: TrainingResponse?, val failure: ErrorResponse?)
sealed class WrapperResponse<in T, in G> {
    data class Success<T>(val data: T) : WrapperResponse<T, Nothing>()
    data class Failure<G>(val error: G) : WrapperResponse<Nothing, G>()
}