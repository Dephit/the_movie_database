package com.sergeenko.data.genres

import com.sergeenko.domain.genre.IGenreDatabase
import com.sergeenko.domain.genre.IGenreRepository
import com.sergeenko.domain.models.Genre
import com.sergeenko.domain.models.Response

class GenreRepository(
    private val genreApi: GenreApi,
    private val genreDatabase: IGenreDatabase
): IGenreRepository {

    override suspend fun getMovieGenreById(id: List<Int>): List<Genre> {
        val responseFromDatabase = genreDatabase.getMovieGenresById(id)
        return responseFromDatabase.ifEmpty {
            val apiResponse = genreApi.getMovieGenres()
            val result = GenreResponseToGenreMapper(apiResponse)
                .map(genreDatabase::addMovieGenre)

            if (result is Response.ResponseSuccess<*>) {
                return result.result as List<Genre>
            }

            return emptyList()
        }
    }

    override suspend fun getTvGenreById(id: List<Int>): List<Genre> {
        val responseFromDatabase = genreDatabase.getTvGenresById(id)
        return responseFromDatabase.ifEmpty {
            val apiResponse = genreApi.getTvGenres()
            val result = GenreResponseToGenreMapper(apiResponse)
                .map(genreDatabase::addTvGenre)

            if (result is Response.ResponseSuccess<*>) {
                return result.result as List<Genre>
            }

            return emptyList()
        }
    }
}