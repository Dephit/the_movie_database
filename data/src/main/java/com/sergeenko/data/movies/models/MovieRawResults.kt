package com.sergeenko.data.movies.models

import com.google.gson.annotations.SerializedName
import com.sergeenko.data.utils.PosterPathBuilder
import com.sergeenko.domain.models.MediaType

import com.sergeenko.domain.models.ShowModel


data class MovieRawResults (

    @SerializedName("adult"             ) var adult            : Boolean?       = null,
    @SerializedName("backdrop_path"     ) var backdropPath     : String?        = null,
    @SerializedName("genre_ids"         ) var genreIds         : ArrayList<Int> = arrayListOf(),
    @SerializedName("id"                ) var id               : Int?           = null,
    @SerializedName("original_language" ) var originalLanguage : String?        = null,
    @SerializedName("original_title"    ) var originalTitle    : String?        = null,
    @SerializedName("overview"          ) var overview         : String?        = null,
    @SerializedName("popularity"        ) var popularity       : Double?        = null,
    @SerializedName("poster_path"       ) var posterPath       : String?        = null,
    @SerializedName("release_date"      ) var releaseDate      : String?        = null,
    @SerializedName("title"             ) var title            : String?        = null,
    @SerializedName("video"             ) var video            : Boolean?       = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?        = null,
    @SerializedName("vote_count"        ) var voteCount        : Int?           = null

) {
    fun toShowModel() = ShowModel(
            id = id ?: 0,
            title = title ?: "",
            year = releaseDate ?: "",
            length = 0,
            genres = genreIds,
            posterPath = PosterPathBuilder()
                .build(posterPath),
            overview = overview ?: "",
            actors = listOf(),
            mediaType = MediaType.Movie
        )

}

