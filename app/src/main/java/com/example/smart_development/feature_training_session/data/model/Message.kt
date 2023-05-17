package com.example.smart_development.feature_training_session.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("role")
    val role: String,
    @SerializedName("content")
    val content: String,
)
