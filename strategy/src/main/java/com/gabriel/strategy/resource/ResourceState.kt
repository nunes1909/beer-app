package com.gabriel.strategy.resource

sealed class ResourceState<T>(
    val data: T? = null,
    val cod: Int? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ResourceState<T>(data)

    class Error<T>(data: T? = null, cod: Int? = null, message: String? = null) :
        ResourceState<T>(data = data, cod = cod, message = message)

    class Loading<T> : ResourceState<T>()

    class Empty<T> : ResourceState<T>()
}
