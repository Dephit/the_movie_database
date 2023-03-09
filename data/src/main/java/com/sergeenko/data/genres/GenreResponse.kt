package com.sergeenko.data.genres

import com.google.gson.annotations.SerializedName
import com.sergeenko.domain.models.Genre

data class GenreResponse (

    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null

) {
    fun toGenre(): Genre {
        return Genre(id = id ?: 0, name = name ?: "")
    }
}