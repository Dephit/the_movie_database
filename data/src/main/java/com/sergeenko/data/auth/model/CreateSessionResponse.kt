package com.sergeenko.data.auth.model

import com.google.gson.annotations.SerializedName

data class CreateSessionResponse (

    @SerializedName("success"    ) var success   : Boolean? = null,
    @SerializedName("session_id" ) var sessionId : String?  = null

)

