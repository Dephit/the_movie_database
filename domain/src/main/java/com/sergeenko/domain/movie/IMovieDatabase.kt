package com.sergeenko.domain.movie

import com.sergeenko.domain.models.ShowModel
import kotlinx.coroutines.flow.Flow

interface IMovieDatabase {

    fun popularMoviesFlow(): List<ShowModel>

    suspend fun addPopularMovies(body: List<ShowModel>)
}

