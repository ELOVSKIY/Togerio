package com.helicoptera.togerio.authorization.validation

import com.helicoptera.togerio.validation.ValidationResult

private const val MIN_PASSWORD_LENGTH = 6

class PasswordValidator {

    fun validatePassword(password: String?): ValidationResult {
        return when {
            password == null -> {
                ValidationResult(errorDescription = "Password can not be null")
            }
            password.length < MIN_PASSWORD_LENGTH -> {
                ValidationResult(errorDescription = " Password should be at least $MIN_PASSWORD_LENGTH characters lon")
            }
            else -> {
                ValidationResult(true)
            }
        }
    }
}