package com.sergeenko.data.search.mapper

import com.sergeenko.data.mapper.RawResponseMapper
import com.sergeenko.data.search.model.MediaTypeMapper
import com.sergeenko.data.search.model.MultiSearchResponse
import com.sergeenko.domain.models.ShowModel

class MultiSearchToShowModelMoviesAndTvMapper(
    response: retrofit2.Response<MultiSearchResponse>
): RawResponseMapper<MultiSearchResponse, List<ShowModel>>(response){



    override fun mapBody(body: MultiSearchResponse?): List<ShowModel>? {
        return body?.results?.mapNotNull {
            val mediaType = MediaTypeMapper(it.mediaType)
            if(mediaType.isMovie() || mediaType.isTv()) {
                it.toShowModel()
            }else null
        }
    }

}