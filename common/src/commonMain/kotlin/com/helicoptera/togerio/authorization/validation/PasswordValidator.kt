package com.helicoptera.togerio.authorization.validation

private const val MIN_PASSWORD_LENGTH = 6

class PasswordValidator {

    private val validator = Validator(
        "Password",
        minLengthSize = MIN_PASSWORD_LENGTH,
    )

    fun validatePassword(password: String?) = validator.validate(password)
}