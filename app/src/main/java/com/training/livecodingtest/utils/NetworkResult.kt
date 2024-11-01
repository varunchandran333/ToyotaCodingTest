package com.training.livecodingtest.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import retrofit2.Response

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val code: Int, val message: String) : NetworkResult<Nothing>()
    data object Loading : NetworkResult<Nothing>()
}

inline fun <reified T> handleApi(crossinline execute: suspend () -> Response<T>) = flow {
    try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            emit(NetworkResult.Success(body))
        } else {
            emit(NetworkResult.Error(response.code(), response.message()))
        }
    } catch (e: HttpException) {
        emit(NetworkResult.Error(e.code(), e.message()))
    }
}.flowOn(Dispatchers.IO)