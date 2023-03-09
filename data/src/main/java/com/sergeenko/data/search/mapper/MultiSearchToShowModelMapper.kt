package com.sergeenko.data.search.mapper

import com.sergeenko.data.mapper.RawResponseMapper
import com.sergeenko.data.search.model.MultiSearchResponse
import com.sergeenko.domain.models.ShowModel

class MultiSearchToShowModelMapper(
    response: retrofit2.Response<MultiSearchResponse>
): RawResponseMapper<MultiSearchResponse, List<ShowModel>>(response){

    override fun mapBody(body: MultiSearchResponse?): List<ShowModel>? {
        return body?.results?.map { it.toShowModel() }
    }

}

