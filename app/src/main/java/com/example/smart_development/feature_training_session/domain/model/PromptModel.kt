package com.example.smart_development.feature_training_session.domain.model

import com.example.smart_development.feature_training_session.data.model.Message
import com.google.gson.annotations.SerializedName

const val MODEL = "gpt-3.5-turbo-0301"
const val ROLE_USER = "user"

data class PromptModel(
    @SerializedName("model")
    val model: String = MODEL,
    @SerializedName("messages")
    val messages: List<Message>
) {


}