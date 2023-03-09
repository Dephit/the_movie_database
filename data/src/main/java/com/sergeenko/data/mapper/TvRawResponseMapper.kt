package com.sergeenko.data.mapper

import com.sergeenko.data.tv.models.PopularTvResponse
import com.sergeenko.domain.models.ShowModel

class TvRawResponseMapper(
    response: retrofit2.Response<PopularTvResponse>
): RawResponseMapper<PopularTvResponse, List<ShowModel>>(response){
    override fun mapBody(body: PopularTvResponse?): List<ShowModel>? {
        return body?.results?.map { it.toShowModel() }
    }

}


