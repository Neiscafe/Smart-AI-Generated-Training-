package com.example.smart_development.feature_training_session.domain.util

import com.example.smart_development.feature_training_session.data.model.Message
import com.example.smart_development.feature_training_session.domain.model.PromptModel
import com.example.smart_development.feature_training_session.domain.model.ROLE_USER
import java.util.regex.Pattern

val EMAIL_ADDRESS_PATTERN = Pattern.compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)

fun String.isValidEmail(): Boolean {
    return EMAIL_ADDRESS_PATTERN.matcher(this).matches()
}

fun String.toPromptModel(): PromptModel {
    return PromptModel(
        messages = listOf(
            Message(content = this, role = ROLE_USER)
        )
    )
}