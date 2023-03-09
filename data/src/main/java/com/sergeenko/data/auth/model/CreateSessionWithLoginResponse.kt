package com.sergeenko.data.auth.model

import com.google.gson.annotations.SerializedName

data class CreateSessionWithLoginResponse (

    @SerializedName("success"       ) var success      : Boolean? = null,
    @SerializedName("expires_at"    ) var expiresAt    : String?  = null,
    @SerializedName("request_token" ) var requestToken : String?  = null

)

