package com.sergeenko.data.movies.mapper

import com.sergeenko.data.mapper.RawResponseMapper
import com.sergeenko.data.movies.models.DetailedMovieResponse
import com.sergeenko.data.movies.models.PopularMovieResponse
import com.sergeenko.domain.models.DetailedMovieModel
import com.sergeenko.domain.models.ShowModel

class MovieToDetailedMapper(
    response: retrofit2.Response<DetailedMovieResponse>
): RawResponseMapper<DetailedMovieResponse, DetailedMovieModel>(response){

    override fun mapBody(body: DetailedMovieResponse?): DetailedMovieModel? {
        return body?.toDetailedMovie()
    }

}