package com.sergeenko.data.auth

import com.sergeenko.data.auth.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @GET("authentication/token/new")
    suspend fun createRequestToken(): Response<CreateRequestTokenResponse>

    @POST("authentication/guest_session/new")
    suspend fun createGuestSession(): Response<CreateGuestSessionResponse>

    @POST("authentication/session/new")
    suspend fun createSession(): Response<CreateSessionResponse>

    @POST("authentication/token/validate_with_login")
    suspend fun createSessionWithLogin(
        @Body body: CreateSessionWithLoginBody
    ): Response<CreateSessionWithLoginResponse>

    @DELETE("authentication/session")
    suspend fun deleteSession(
        @Body body: DeleteSessionBody
    ): Response<DeleteSessionResponse>


}


