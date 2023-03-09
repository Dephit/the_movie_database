package com.sergeenko.data.movies

import com.sergeenko.data.mapper.MovieRawResponseMapper
import com.sergeenko.data.movies.mapper.MovieToDetailedMapper
import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.domain.movie.IMovieDatabase
import com.sergeenko.domain.movie.IMovieRepository

class MovieRepository(
    private val movieDatabase: IMovieDatabase,
    private val movieApi: MovieApi,
) : IMovieRepository {

    override suspend fun getPopularMovies(currentPage: Int): List<ShowModel> {
        val response = movieApi.getPopularMovies(page = currentPage)
        val mapper = MovieRawResponseMapper(response)
        val list = mapper.getOrNull()
        list?.let{
            movieDatabase.addPopularMovies(it)
        }
        return list ?: emptyList()

    }

    override suspend fun getMovieById(id: Int): Response {
        val response = movieApi.getMovieById(movieId = id)
        val mapper = MovieToDetailedMapper(response)
        return mapper
            .map()
    }


}


