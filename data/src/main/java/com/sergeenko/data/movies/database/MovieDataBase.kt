package com.sergeenko.data.movies.database

import com.sergeenko.domain.models.ShowModel
import com.sergeenko.domain.movie.IMovieDatabase

class MovieDataBase: IMovieDatabase {


    override fun popularMoviesFlow(): List<ShowModel> {
        return emptyList()
    }

    override suspend fun addPopularMovies(body: List<ShowModel>) {

    }

    override fun getPopularMovies(currentPage: Int): List<ShowModel>? {
        return null
    }
}