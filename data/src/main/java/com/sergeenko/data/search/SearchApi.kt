package com.sergeenko.data.search

import com.sergeenko.data.movies.models.PopularMovieResponse
import com.sergeenko.data.search.model.MultiSearchResponse
import com.sergeenko.data.tv.models.PopularTvResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("search/movie")
    suspend fun findMoviesByQuery(
        @Query("query") query: String,
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null,
        @Query("region") region: String? = null,
        @Query("include_adult") includeAdult: Boolean? = true,
        @Query("year") year: Int? = null,
        @Query("primary_release_year") primaryReleaseYear: Int? = null
    ): Response<PopularMovieResponse>


    @GET("search/tv")
    suspend fun findTvByQuery(
        @Query("query") query: String,
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null,
        @Query("region") region: String? = null,
        @Query("include_adult") includeAdult: Boolean? = null,
        @Query("first_air_date_year") firstAirDateYear: Int? = null,
    ): Response<PopularTvResponse>

    @GET("search/multi")
    suspend fun findMultiByQuery(
        @Query("query") query: String,
        @Query("language") language: String? = null,
        @Query("page") page: Int? = null,
        @Query("region") region: String? = null,
        @Query("include_adult") includeAdult: Boolean? = null,
        @Query("year") year: Int? = null,
        @Query("primary_release_year") primaryReleaseYear: Int? = null
    ): Response<MultiSearchResponse>
}

