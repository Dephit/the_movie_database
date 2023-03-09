package com.sergeenko.data.auth.model

import com.google.gson.annotations.SerializedName

data class DeleteSessionResponse (

    @SerializedName("success" ) var success : Boolean? = null

)