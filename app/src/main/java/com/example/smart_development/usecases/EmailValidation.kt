package com.example.smart_development.usecases

import com.example.smart_development.util.isValidEmail

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