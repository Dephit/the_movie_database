package com.sergeenko.data.auth.model

import com.google.gson.annotations.SerializedName

data class CreateSessionWithLoginBody (

    @SerializedName("username"      ) var username     : String? = null,
    @SerializedName("password"      ) var password     : String? = null,
    @SerializedName("request_token" ) var requestToken : String? = null

)

data class DeleteSessionBody (
    @SerializedName("session_id"      ) var sessionId     : String? = null,

)