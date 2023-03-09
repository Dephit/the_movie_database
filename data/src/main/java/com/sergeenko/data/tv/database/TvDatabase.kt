package com.sergeenko.data.tv.database

import com.sergeenko.domain.models.ShowModel
import com.sergeenko.domain.tv.ITvDatabase

class TvDatabase: ITvDatabase {
    override fun popularTvs(): List<ShowModel> {
        return emptyList()
    }

    override suspend fun addPopularTv(body: List<ShowModel>) {

    }


}