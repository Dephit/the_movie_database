package com.sergeenko.data.tv.mapper

import com.sergeenko.data.mapper.RawResponseMapper
import com.sergeenko.data.tv.models.DetailedTvResponse
import com.sergeenko.domain.models.DetailedMovieModel

class TvResponseToDetailedMovieMapper(
    response: retrofit2.Response<DetailedTvResponse>
): RawResponseMapper<DetailedTvResponse, DetailedMovieModel>(response){
    override fun mapBody(body: DetailedTvResponse?): DetailedMovieModel? {
        return body?.toDetailedMovie()
    }

}