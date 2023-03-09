package com.sergeenko.domain.genre

import com.sergeenko.domain.models.Genre

interface IGenreDatabase {

    suspend fun getMovieGenresById(list: List<Int>): List<Genre>

    suspend fun addMovieGenre(genres: List<Genre>)

    suspend fun getTvGenresById(list: List<Int>): List<Genre>

    suspend fun addTvGenre(genres: List<Genre>)
}