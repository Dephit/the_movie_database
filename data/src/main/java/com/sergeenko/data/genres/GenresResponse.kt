package com.sergeenko.data.genres

import com.google.gson.annotations.SerializedName

data class GenresResponse (

    @SerializedName("genres" ) var genres : ArrayList<GenreResponse> = arrayListOf()

)