package com.sergeenko.domain.models

data class ErrorResponse(
    val code: Int = 404, val message: String = "Not Found"
)