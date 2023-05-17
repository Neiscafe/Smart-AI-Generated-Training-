package com.example.smart_development.feature_training_session.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

const val ROLE = "user"

data class Message(
    @SerializedName("role")
    @Expose
    val role: String = ROLE,
    @SerializedName("content")
    @Expose
    val content: String,
)
