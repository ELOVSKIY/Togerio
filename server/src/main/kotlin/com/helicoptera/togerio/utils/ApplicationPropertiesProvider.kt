package com.helicoptera.togerio.utils

import io.ktor.application.*

fun getApplicationProperty(
    environment: ApplicationEnvironment,
    propertyName: String
): String {
    return environment.config.property(propertyName).getString()
}

fun getApplicationProperty(
    environment: ApplicationEnvironment,
    propertyName: String,
    defaultValue: String,
) : String {
    return environment.config.propertyOrNull(propertyName)?.getString() ?: defaultValue
}
