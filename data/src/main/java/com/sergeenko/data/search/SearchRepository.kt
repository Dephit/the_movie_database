package com.sergeenko.data.search

import com.sergeenko.data.mapper.MovieRawResponseMapper
import com.sergeenko.data.mapper.TvRawResponseMapper
import com.sergeenko.data.search.mapper.MultiSearchToShowModelMoviesAndTvMapper
import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.domain.search.ISearchRepository

class SearchRepository(
    private val searchApi: SearchApi,
) : ISearchRepository {
    override suspend fun findShowsByName(name: String): Response {
        val response = searchApi.findMultiByQuery(name)
        val mapper = MultiSearchToShowModelMoviesAndTvMapper(response)
        return mapper.map()
    }

    override suspend fun findMoviesByName(name: String): List<ShowModel> {
        val responseMovies = searchApi.findMoviesByQuery(name)
        val movieMapper = MovieRawResponseMapper(responseMovies)
        return movieMapper.getOrNull() ?: emptyList()
    }

    override suspend fun findTvsByName(name: String): List<ShowModel> {
        val responseTvs = searchApi.findTvByQuery(name)
        val tvMapper = TvRawResponseMapper(responseTvs)
        return tvMapper.getOrNull() ?: emptyList()
    }


}