package com.sergeenko.data.tv.models

import com.google.gson.annotations.SerializedName
import com.sergeenko.data.utils.PosterPathBuilder
import com.sergeenko.domain.models.MediaType
import com.sergeenko.domain.models.ShowModel

data class TvRawResponse (

    @SerializedName("backdrop_path"     ) var backdropPath     : String?           = null,
    @SerializedName("first_air_date"    ) var firstAirDate     : String?           = null,
    @SerializedName("genre_ids"         ) var genreIds         : ArrayList<Int>    = arrayListOf(),
    @SerializedName("id"                ) var id               : Int?              = null,
    @SerializedName("name"              ) var name             : String?           = null,
    @SerializedName("origin_country"    ) var originCountry    : ArrayList<String> = arrayListOf(),
    @SerializedName("original_language" ) var originalLanguage : String?           = null,
    @SerializedName("original_name"     ) var originalName     : String?           = null,
    @SerializedName("overview"          ) var overview         : String?           = null,
    @SerializedName("popularity"        ) var popularity       : Double?           = null,
    @SerializedName("poster_path"       ) var posterPath       : String?           = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?           = null,
    @SerializedName("vote_count"        ) var voteCount        : Int?              = null

){

    fun toShowModel() = ShowModel(
        id = id ?: 0,
        title = name!!,
        year = firstAirDate ?: "",
        length = 0,
        genres = genreIds,
        posterPath = PosterPathBuilder().build(posterPath),
        overview = overview!!,
        actors = listOf(),
        mediaType = MediaType.TV
    )
}