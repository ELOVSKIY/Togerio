package com.helicoptera.togerio.authorization.validation

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
                    ValidationResult(errorDescription = "$validationObjectName can not be null")
                }
            }
            minLengthSize != null && validationObject.length < minLengthSize -> {
                ValidationResult(errorDescription = "$validationObjectName should be at least $minLengthSize characters long")
            }
            maxLengthSize != null && validationObject.length > maxLengthSize -> {
                ValidationResult(errorDescription = "$validationObjectName should not be at least $maxLengthSize characters long")
            }
            pattern != null && !pattern.toRegex().matches(validationObject) -> {
                ValidationResult(errorDescription = "$validationObjectName ");
            }
            else -> {
                ValidationResult(true)
            }
        }
    }
}