package com.sergeenko.data.tv.models

import com.google.gson.annotations.SerializedName

data class PopularTvResponse (

  @SerializedName("page"          ) var page         : Int?               = null,
  @SerializedName("results"       ) var results      : ArrayList<TvRawResponse> = arrayListOf(),
  @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
  @SerializedName("total_results" ) var totalResults : Int?               = null

)

