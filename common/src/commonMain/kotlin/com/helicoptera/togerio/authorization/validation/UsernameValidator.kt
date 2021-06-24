package com.helicoptera.togerio.authorization.validation

import com.helicoptera.togerio.validation.ValidationResult

private const val MIN_USERNAME_LENGTH = 6
private const val USERNAME_PATTERN = "[a-zA-Z0-9_.]+"

class UsernameValidator {

    fun validateUsername(username: String): ValidationResult {
        return if (username.length < MIN_USERNAME_LENGTH) {
            ValidationResult(errorDescription = "Login should be at least $MIN_USERNAME_LENGTH characters long")
        } else if (!USERNAME_PATTERN.toRegex().matches(username)) {
            ValidationResult(errorDescription = "Login should be consists of digits, letters, dots or underscores");
        } else {
            ValidationResult(true)
        }
    }
}