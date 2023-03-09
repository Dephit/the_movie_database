package com.sergeenko.data.tv.models

import com.google.gson.annotations.SerializedName
import com.sergeenko.data.genres.GenreResponse
import com.sergeenko.data.production_companies.models.ProductionCompanies
import com.sergeenko.data.production_countries.models.ProductionCountries
import com.sergeenko.data.spocken_languages.models.SpokenLanguages
import com.sergeenko.data.utils.PosterPathBuilder
import com.sergeenko.data.utils.RuntimeBuilder
import com.sergeenko.domain.models.DetailedMovieModel

data class DetailedTvResponse (

  @SerializedName("adult"                ) var adult               : Boolean?                       = null,
  @SerializedName("backdrop_path"        ) var backdropPath        : String?                        = null,
  @SerializedName("created_by"           ) var createdBy           : ArrayList<CreatedBy>           = arrayListOf(),
  @SerializedName("episode_run_time"     ) var episodeRunTime      : ArrayList<Int>                 = arrayListOf(),
  @SerializedName("first_air_date"       ) var firstAirDate        : String?                        = null,
  @SerializedName("genres"               ) var genres              : ArrayList<GenreResponse>              = arrayListOf(),
  @SerializedName("homepage"             ) var homepage            : String?                        = null,
  @SerializedName("id"                   ) var id                  : Int?                           = null,
  @SerializedName("in_production"        ) var inProduction        : Boolean?                       = null,
  @SerializedName("languages"            ) var languages           : ArrayList<String>              = arrayListOf(),
  @SerializedName("last_air_date"        ) var lastAirDate         : String?                        = null,
  @SerializedName("last_episode_to_air"  ) var lastEpisodeToAir    : LastEpisodeToAir?              = LastEpisodeToAir(),
  @SerializedName("name"                 ) var name                : String?                        = null,
  @SerializedName("next_episode_to_air"  ) var nextEpisodeToAir    : String?                        = null,
  @SerializedName("networks"             ) var networks            : ArrayList<Networks>            = arrayListOf(),
  @SerializedName("number_of_episodes"   ) var numberOfEpisodes    : Int?                           = null,
  @SerializedName("number_of_seasons"    ) var numberOfSeasons     : Int?                           = null,
  @SerializedName("origin_country"       ) var originCountry       : ArrayList<String>              = arrayListOf(),
  @SerializedName("original_language"    ) var originalLanguage    : String?                        = null,
  @SerializedName("original_name"        ) var originalName        : String?                        = null,
  @SerializedName("overview"             ) var overview            : String?                        = null,
  @SerializedName("popularity"           ) var popularity          : Double?                        = null,
  @SerializedName("poster_path"          ) var posterPath          : String?                        = null,
  @SerializedName("production_companies" ) var productionCompanies : ArrayList<ProductionCompanies> = arrayListOf(),
  @SerializedName("production_countries" ) var productionCountries : ArrayList<ProductionCountries>              = arrayListOf(),
  @SerializedName("seasons"              ) var seasons             : ArrayList<Seasons>             = arrayListOf(),
  @SerializedName("spoken_languages"     ) var spokenLanguages     : ArrayList<SpokenLanguages>     = arrayListOf(),
  @SerializedName("status"               ) var status              : String?                        = null,
  @SerializedName("tagline"              ) var tagline             : String?                        = null,
  @SerializedName("type"                 ) var type                : String?                        = null,
  @SerializedName("vote_average"         ) var voteAverage         : Double?                           = null,
  @SerializedName("vote_count"           ) var voteCount           : Double?                           = null

){

  fun toDetailedMovie(): DetailedMovieModel {
    return DetailedMovieModel(
      adult = adult,
      backdropPath = backdropPath,
      genres = genres.map { it.toGenre() },
      homepage = homepage,
      id = id,
      originalLanguage = originalLanguage,
      originalTitle = originalName,
      overview = overview,
      popularity = popularity,
      posterPath = PosterPathBuilder()
        .addSize(PosterPathBuilder.Size.original)
        .build(posterPath),
      releaseDate = firstAirDate,
      runtime = RuntimeBuilder().build(episodeRunTime.average().toLong()),
      status = status,
      tagline = tagline,
      title = name,
      voteAverage = voteAverage,
      voteCount = voteCount

    )
  }
}

