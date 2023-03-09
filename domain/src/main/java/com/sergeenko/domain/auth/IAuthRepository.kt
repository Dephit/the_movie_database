package com.sergeenko.domain.auth

import com.sergeenko.domain.auth.model.LoginModel
import com.sergeenko.domain.models.Response

interface IAuthRepository {

    suspend fun createSession(): Response

    suspend fun createSessionWithLogin(
        model: LoginModel
    ): Response

    suspend fun deleteSession()

}