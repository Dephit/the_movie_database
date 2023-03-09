package com.sergeenko.data.movies


import com.sergeenko.data.movies.models.DetailedMovieResponse
import com.sergeenko.data.movies.models.PopularMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null,
        @Query("region") region: String? = null
    ): Response<PopularMovieResponse>


    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null,
        @Query("region") region: String? = null
    ): Response<DetailedMovieResponse>
}


