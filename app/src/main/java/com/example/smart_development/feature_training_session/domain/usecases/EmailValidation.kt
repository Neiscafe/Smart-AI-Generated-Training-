package com.example.smart_development.feature_training_session.domain.usecases

import com.example.smart_development.feature_training_session.domain.util.isValidEmail

class EmailValidation() {
    fun execute(email: String): Validation {
        if (email.isNullOrEmpty()) {
            return Validation(sucessfull = false, message = "This field is mandatory")
        }
        if (!email.isValidEmail()) {
            return Validation(sucessfull = false, message = "This is not a valid email adress")
        }
        return Validation(sucessfull = true)
    }
}