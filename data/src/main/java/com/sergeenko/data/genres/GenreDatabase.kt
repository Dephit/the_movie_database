package com.sergeenko.data.genres

import com.sergeenko.domain.genre.IGenreDatabase
import com.sergeenko.domain.models.Genre

class GenreDatabase: IGenreDatabase {

    private val movieGenres = mutableSetOf<Genre>()
    private val tvGenres = mutableSetOf<Genre>()

    override suspend fun getMovieGenresById(list: List<Int>): List<Genre> {
        return movieGenres.filter { list.contains(it.id) }
    }

    override suspend fun addMovieGenre(genres: List<Genre>) {
        movieGenres.addAll(genres)
    }

    override suspend fun getTvGenresById(list: List<Int>): List<Genre> {
        return tvGenres.filter { list.contains(it.id) }
    }

    override suspend fun addTvGenre(genres: List<Genre>) {
        tvGenres.addAll(genres)
    }


}