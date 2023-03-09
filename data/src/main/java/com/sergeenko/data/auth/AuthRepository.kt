package com.sergeenko.data.auth

import com.sergeenko.domain.auth.IAuthDatabase
import com.sergeenko.domain.auth.IAuthRepository
import com.sergeenko.domain.auth.model.LoginModel
import com.sergeenko.domain.models.Response

class AuthRepository(
    val api: AuthApi,
    val database: IAuthDatabase
): IAuthRepository {

    override suspend fun createSession(): Response {
        TODO("Not yet implemented")
    }

    override suspend fun createSessionWithLogin(model: LoginModel): Response {
        TODO("Not yet implemented")
    }

    override suspend fun deleteSession() {
        TODO("Not yet implemented")
    }
}

