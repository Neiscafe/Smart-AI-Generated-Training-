package com.example.smart_development.feature_training_session.data.model

import com.google.gson.annotations.SerializedName


data class TrainingResponse(
    val id: String,
    val usage: Usage,
    val choices: List<Choice>
)

data class Usage(
    @SerializedName("prompt_tokens")
    val promptTokens: Int,
    @SerializedName("completion_tokens")
    val completionTokens: Int,
    @SerializedName("total_tokens")
    val totalTokens: Int
)
data class Choice(
    val message: Message,
    @SerializedName("finish_reason")
    val finishReason: String,
    val index: Int
)
