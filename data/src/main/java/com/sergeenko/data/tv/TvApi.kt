package com.sergeenko.data.tv

import com.sergeenko.data.movies.models.PopularMovieResponse
import com.sergeenko.data.tv.models.DetailedTvResponse
import com.sergeenko.data.tv.models.PopularTvResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvApi {

    @GET("tv/popular")
    suspend fun getPopularTv(
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null
    ): Response<PopularTvResponse>

    @GET("tv/{tv_id}")
    suspend fun getTvById(
        @Path("tv_id") tvId: Int,
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null
    ): Response<DetailedTvResponse>

}