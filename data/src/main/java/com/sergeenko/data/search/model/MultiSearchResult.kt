package com.sergeenko.data.search.model

import com.google.gson.annotations.SerializedName
import com.sergeenko.data.utils.PosterPathBuilder
import com.sergeenko.domain.models.MediaType
import com.sergeenko.domain.models.ShowModel

data class MultiSearchResult (

    @SerializedName("adult"             ) var adult            : Boolean?       = null,
    @SerializedName("backdrop_path"     ) var backdropPath     : String?        = null,
    @SerializedName("id"                ) var id               : Int?           = null,
    @SerializedName("title"             ) var title            : String?        = null,
    @SerializedName("original_language" ) var originalLanguage : String?        = null,
    @SerializedName("original_title"    ) var originalTitle    : String?        = null,
    @SerializedName("overview"          ) var overview         : String?        = null,
    @SerializedName("poster_path"       ) var posterPath       : String?        = null,
    @SerializedName("media_type"        ) var mediaType        : String?        = null,
    @SerializedName("genre_ids"         ) var genreIds         : ArrayList<Int> = arrayListOf(),
    @SerializedName("popularity"        ) var popularity       : Double?        = null,
    @SerializedName("release_date"      ) var releaseDate      : String?        = null,
    @SerializedName("video"             ) var video            : Boolean?       = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?        = null,
    @SerializedName("vote_count"        ) var voteCount        : Int?           = null

){
    fun toShowModel() = ShowModel(
        id = 0,
        title = title ?: originalTitle ?: "",
        year = releaseDate ?: "",
        length = 0,
        genres = genreIds,
        posterPath = PosterPathBuilder().build(posterPath),
        overview = overview ?: "",
        actors = listOf(),
        mediaType = MediaTypeMapper(mediaType).fromString()

    )
}

class MediaTypeMapper(val string: String?){

    private val tv = "tv"
    private val movie = "movie"
    private val person = "person"

    fun fromString() = when(string){
        tv -> MediaType.TV
        movie -> MediaType.Movie
        person -> MediaType.Person
        else -> MediaType.Unknown
    }

    fun isMovie() = string == movie
    fun isTv() = string == tv
}