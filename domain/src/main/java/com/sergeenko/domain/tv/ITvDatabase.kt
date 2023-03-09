package com.sergeenko.domain.tv

import com.sergeenko.domain.models.ShowModel

interface ITvDatabase {

    fun popularTvs(): List<ShowModel>

    suspend fun addPopularTv(body: List<ShowModel>)
}

