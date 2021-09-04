package com.helicoptera.togerio.data.network

import io.ktor.client.*

//TODO remove after implements
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect fun createKtorClient(config: HttpClientConfig<*>.() -> Unit): HttpClient