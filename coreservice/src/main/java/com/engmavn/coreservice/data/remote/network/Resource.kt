package com.demo.coreservice.data.remote.network

// A generic class that contains data and status about loading this data.
sealed class Resource<T>(
        val data: T? = null,
        val t : Throwable ?= null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(t: Throwable) : Resource<T>(null, t)
}