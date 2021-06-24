package com.helicoptera.togerio.validation

data class ValidationResult(
    val valid: Boolean = false,
    val errorDescription: String = ""
)
