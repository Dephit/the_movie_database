package com.sergeenko.data.genres

import com.sergeenko.data.mapper.RawResponseMapper
import com.sergeenko.domain.models.Genre

class GenreResponseToGenreMapper(
    response: retrofit2.Response<GenresResponse>
): RawResponseMapper<GenresResponse, List<Genre>>(response){

    override fun mapBody(body: GenresResponse?): List<Genre>? {
        return body?.genres?.map{
            it.toGenre()
        }
    }


}