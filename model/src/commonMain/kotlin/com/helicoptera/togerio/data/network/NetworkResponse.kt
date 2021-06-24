package com.helicoptera.togerio.data.network

data class NetworkResponse<T>(
    val value: T? = null,
    val error: String? = null
)
