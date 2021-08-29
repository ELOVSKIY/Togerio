package com.helicoptera.togerio.validation

data class ValidationError (
    val validationMetricValue: String? = null,
    val validationErrorCode: ValidationErrorCode
)