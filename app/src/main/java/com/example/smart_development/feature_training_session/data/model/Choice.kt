package com.example.smart_development.feature_training_session.data.model

import com.google.gson.annotations.SerializedName

data class Choice(
    val message: Message,
    @SerializedName("finish_reason")
    val finishReason: String,
    val index: Int
)
