package com.sergeenko.data.movies.models

import com.google.gson.annotations.SerializedName
import com.sergeenko.data.genres.GenreResponse
import com.sergeenko.data.production_companies.models.ProductionCompanies
import com.sergeenko.data.production_countries.models.ProductionCountries
import com.sergeenko.data.spocken_languages.models.SpokenLanguages
import com.sergeenko.data.utils.PosterPathBuilder
import com.sergeenko.data.utils.RuntimeBuilder
import com.sergeenko.domain.models.DetailedMovieModel

data class DetailedMovieResponse (

  @SerializedName("adult"                 ) var adult               : Boolean?                       = null,
  @SerializedName("backdrop_path"         ) var backdropPath        : String?                        = null,
  //@SerializedName("belongs_to_collection" ) var belongsToCollection : String?                        = null,
  @SerializedName("budget"                ) var budget              : Int?                           = null,
  @SerializedName("genres"                ) var genres              : ArrayList<GenreResponse>              = arrayListOf(),
  @SerializedName("homepage"              ) var homepage            : String?                        = null,
  @SerializedName("id"                    ) var id                  : Int?                           = null,
  @SerializedName("imdb_id"               ) var imdbId              : String?                        = null,
  @SerializedName("original_language"     ) var originalLanguage    : String?                        = null,
  @SerializedName("original_title"        ) var originalTitle       : String?                        = null,
  @SerializedName("overview"              ) var overview            : String?                        = null,
  @SerializedName("popularity"            ) var popularity          : Double?                        = null,
  @SerializedName("poster_path"           ) var posterPath          : String?                        = null,
  @SerializedName("production_companies"  ) var productionCompanies : ArrayList<ProductionCompanies> = arrayListOf(),
  @SerializedName("production_countries"  ) var productionCountries : ArrayList<ProductionCountries> = arrayListOf(),
  @SerializedName("release_date"          ) var releaseDate         : String?                        = null,
  @SerializedName("revenue"               ) var revenue             : Int?                           = null,
  @SerializedName("runtime"               ) var runtime             : Int?                           = null,
  @SerializedName("spoken_languages"      ) var spokenLanguages     : ArrayList<SpokenLanguages>     = arrayListOf(),
  @SerializedName("status"                ) var status              : String?                        = null,
  @SerializedName("tagline"               ) var tagline             : String?                        = null,
  @SerializedName("title"                 ) var title               : String?                        = null,
  @SerializedName("video"                 ) var video               : Boolean?                       = null,
  @SerializedName("vote_average"          ) var voteAverage         : Double?                        = null,
  @SerializedName("vote_count"            ) var voteCount           : Double?                           = null

) {
  fun toDetailedMovie(): DetailedMovieModel {
    return DetailedMovieModel(
      adult = adult,
      backdropPath = backdropPath,
      //belongsToCollection = belongsToCollection,
      budget = budget,
      genres = genres.map { it.toGenre() },
      homepage = homepage,
      id = id,
      imdbId = imdbId,
      originalLanguage = originalLanguage,
      originalTitle = originalTitle,
      overview = overview,
      popularity = popularity,
      posterPath = PosterPathBuilder()
        .addSize(PosterPathBuilder.Size.original)
        .build(posterPath),
      releaseDate = releaseDate,
      revenue = revenue,
      runtime = RuntimeBuilder().build(runtime?.toLong()),
      status = status,
      tagline = tagline,
      title = title,
      video = video,
      voteAverage = voteAverage,
      voteCount = voteCount

    )
  }
}