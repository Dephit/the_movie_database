package com.sergeenko.domain.models

sealed class Response{

    class ResponseSuccess<T>(val result: T): Response()

    class ResponseError(val error: ErrorResponse): Response()


}