package com.example.smart_development.feature_training_session.domain.usecases

import com.example.smart_development.feature_training_session.domain.util.isValidEmail

class EmailValidation() {
    fun execute(email: String): Validation {
        if (email.isNullOrEmpty()) {
            return Validation(successfull = false, message = "This field is mandatory")
        }
        if (!email.isValidEmail()) {
            return Validation(successfull = false, message = "This is not a valid email adress")
        }
        return Validation(successfull = true)
    }
}