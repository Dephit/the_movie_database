package com.sergeenko.domain.movie

import com.sergeenko.domain.models.DetailedMovieModel
import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel

interface IMovieRepository {

    suspend fun getPopularMovies(currentPage: Int): List<ShowModel>

    suspend fun getMovieById(id: Int): Response

}