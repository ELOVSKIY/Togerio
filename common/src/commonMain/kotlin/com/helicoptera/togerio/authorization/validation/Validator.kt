package com.helicoptera.togerio.authorization.validation

import com.helicoptera.togerio.validation.ValidationError
import com.helicoptera.togerio.validation.ValidationErrorCode
import com.helicoptera.togerio.validation.ValidationResult

internal class Validator(
    private val validationObjectName: String,
    private val nullable: Boolean = false,
    private val minLengthSize: Int? = null,
    private val maxLengthSize: Int? = null,
    private val pattern: String? = null,
    private val patternDescription: String? = null
) {

    fun validate(validationObject: String?): ValidationResult {
        return when {
            validationObject == null -> {
                if (nullable) {
                    ValidationResult(true)
                } else {
                    ValidationResult(validationError = ValidationError(validationErrorCode = ValidationErrorCode.NULL_VALUE))
                }
            }
            minLengthSize != null && validationObject.length < minLengthSize -> {
                ValidationResult(validationError = ValidationError("$minLengthSize", ValidationErrorCode.TOO_SMALL))
            }
            maxLengthSize != null && validationObject.length > maxLengthSize -> {
                ValidationResult(validationError = ValidationError("$maxLengthSize", ValidationErrorCode.TOO_LARGE))
            }
            pattern != null && !pattern.toRegex().matches(validationObject) -> {
                ValidationResult(validationError = ValidationError(pattern, ValidationErrorCode.INVALID_PATTERN));
            }
            else -> {
                ValidationResult(true)
            }
        }
    }
}