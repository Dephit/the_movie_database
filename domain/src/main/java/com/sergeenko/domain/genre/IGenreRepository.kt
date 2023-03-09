package com.sergeenko.domain.genre

import com.sergeenko.domain.models.Genre

interface IGenreRepository {

    suspend fun getMovieGenreById(id: List<Int>): List<Genre>

    suspend fun getTvGenreById(id: List<Int>): List<Genre>
}