package com.sergeenko.domain.tv

import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel

interface ITvRepository {

    suspend fun getPopularTv(currentPage: Int): List<ShowModel>

    suspend fun getTvById(id: Int): Response

}

