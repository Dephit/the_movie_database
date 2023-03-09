package com.sergeenko.data.search.model

import com.google.gson.annotations.SerializedName

data class MultiSearchResponse (

    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : ArrayList<MultiSearchResult> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null

)

