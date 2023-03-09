package com.sergeenko.data.tv

import com.sergeenko.data.mapper.TvRawResponseMapper
import com.sergeenko.data.tv.mapper.TvResponseToDetailedMovieMapper
import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.domain.tv.ITvDatabase
import com.sergeenko.domain.tv.ITvRepository

class TvRepository(
    private val tvApi: TvApi,
    private val tvDatabase: ITvDatabase
): ITvRepository {

    override suspend fun getPopularTv(currentPage: Int): List<ShowModel> {
        val response = tvApi.getPopularTv(page = currentPage)
        val mapper = TvRawResponseMapper(response)
        val list = mapper.getOrNull()
        list?.let{
            tvDatabase.addPopularTv(it)
        }
        return list ?: emptyList()
    }

    override suspend fun getTvById(id: Int): Response {
        val response = tvApi.getTvById(tvId = id)
        val mapper = TvResponseToDetailedMovieMapper(response)
        return mapper
            .map()
    }


}