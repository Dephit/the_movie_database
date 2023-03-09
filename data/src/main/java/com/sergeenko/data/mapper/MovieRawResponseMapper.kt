package com.sergeenko.data.mapper

import com.sergeenko.data.movies.models.PopularMovieResponse
import com.sergeenko.domain.models.ShowModel

class MovieRawResponseMapper(
    response: retrofit2.Response<PopularMovieResponse>
): RawResponseMapper<PopularMovieResponse, List<ShowModel>>(response){

    override fun mapBody(body: PopularMovieResponse?): List<ShowModel>? {
        return body?.results?.map { it.toShowModel() }
    }

}


