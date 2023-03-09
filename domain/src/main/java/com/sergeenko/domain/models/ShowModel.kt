package com.sergeenko.domain.models

data class ShowModel(
    val id: Int,
    val title: String,
    val year: String,
    val length: Long,
    val genres: List<Int>,
    val posterPath: String,
    val overview: String,
    val actors: List<Cast>,
    val mediaType: MediaType
): java.io.Serializable {

    fun toDetailedMovie(): DetailedMovieModel? {
        return  DetailedMovieModel(
            id = id,
            title = title,
            releaseDate = year,
            runtime = "",
            posterPath = posterPath,
            overview = overview
        )
    }
}


