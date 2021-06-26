package com.helicoptera.togerio.authorization.validation

private const val MIN_USERNAME_LENGTH = 6
private const val USERNAME_PATTERN = "[a-zA-Z0-9_.]+"
private const val USERNAME_PATTERN_DESCRIPTION = "should be consists of digits, letters, dots or underscores"

class UsernameValidator {

    private val validator = Validator(
        "Username",
        minLengthSize = MIN_USERNAME_LENGTH,
        pattern = USERNAME_PATTERN,
        patternDescription = USERNAME_PATTERN_DESCRIPTION
    )

    fun validateUsername(username: String?) = validator.validate(username)
}