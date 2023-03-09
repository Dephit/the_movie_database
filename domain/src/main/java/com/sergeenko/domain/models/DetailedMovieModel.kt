package com.sergeenko.domain.models

data class DetailedMovieModel(
    var adult               : Boolean?                       = null,
    var backdropPath        : String?                        = null,
    var belongsToCollection : String?                        = null,
    var budget              : Int?                           = null,
    var genres              : List<Genre>              = arrayListOf(),
    var homepage            : String?                        = null,
    var id                  : Int?                           = null,
    var imdbId              : String?                        = null,
    var originalLanguage    : String?                        = null,
    var originalTitle       : String?                        = null,
    var overview            : String?                        = null,
    var popularity          : Double?                        = null,
    var posterPath          : String?                        = null,
    /*var productionCompanies : ArrayList<ProductionCompanies> = arrayListOf(),
    var productionCountries : ArrayList<ProductionCountries> = arrayListOf(),*/
    var releaseDate         : String?                        = null,
    var revenue             : Int?                           = null,
    var runtime             : String                           = "",
    /*var spokenLanguages     : ArrayList<SpokenLanguages>     = arrayListOf(),*/
    var status              : String?                        = null,
    var tagline             : String?                        = null,
    var title               : String?                        = null,
    var video               : Boolean?                       = null,
    var voteAverage         : Double?                        = null,
    var voteCount           : Double? = null
): java.io.Serializable