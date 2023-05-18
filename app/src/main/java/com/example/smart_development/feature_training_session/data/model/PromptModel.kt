package com.example.smart_development.feature_training_session.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

const val MODEL = "gpt-3.5-turbo-0301"

data class PromptModel(
    @SerializedName("model")
    val model: String = MODEL,
    @SerializedName("messages")
    val messages: List<Message>
) {


}