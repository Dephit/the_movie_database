package com.sergeenko.domain.search

import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel

interface ISearchRepository {

    suspend fun findShowsByName(name: String): Response

    suspend fun findMoviesByName(name: String): List<ShowModel>

    suspend fun findTvsByName(name: String): List<ShowModel>

}