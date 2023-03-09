package com.sergeenko.data.genres


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreApi {

    @GET("genre/movie/list")
    suspend fun getMovieGenres(
        @Query("language") language: String? = null
    ): Response<GenresResponse>

    @GET("genre/tv/list")
    suspend fun getTvGenres(
        @Query("language") language: String? = null
    ): Response<GenresResponse>
}

