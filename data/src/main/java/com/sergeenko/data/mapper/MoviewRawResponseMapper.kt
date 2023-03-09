package com.sergeenko.data.mapper

import com.sergeenko.domain.models.ErrorResponse
import com.sergeenko.domain.models.Response

abstract class RawResponseMapper<T, V>(
    private val response: retrofit2.Response<T>
){

    abstract fun mapBody(body: T?): V?

    suspend fun map(onSuccess: suspend (V) -> Unit = {}): Response {
        return if(response.isSuccessful){
            val body = mapBody(response.body())
            if(body != null){
                onSuccess(body)
            }
            Response.ResponseSuccess(body)
        }else{
            Response.ResponseError(ErrorResponse(response.code(), message = response.message()))
        }
    }

    fun getOrNull() = if(response.isSuccessful){ mapBody(response.body()) } else null
}


