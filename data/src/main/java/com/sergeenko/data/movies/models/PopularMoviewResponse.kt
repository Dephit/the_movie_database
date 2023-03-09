package com.sergeenko.data.movies.models

import com.google.gson.annotations.SerializedName

data class PopularMovieResponse (

    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<MovieRawResults> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null

)

