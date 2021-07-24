package data.network

import com.helicoptera.togerio.data.network.NetworkResponse

object ResponseProcessor {
    fun <T>processResponse(response: NetworkResponse<T>) : T {
        response.error?.let {
            throw ApiException(it)
        }
        response.value?.let {
            return it
        }

        throw IllegalStateException()
    }
}