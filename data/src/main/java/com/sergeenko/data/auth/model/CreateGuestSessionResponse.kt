package com.sergeenko.data.auth.model

import com.google.gson.annotations.SerializedName

data class CreateGuestSessionResponse (

    @SerializedName("success"          ) var success        : Boolean? = null,
    @SerializedName("guest_session_id" ) var guestSessionId : String?  = null,
    @SerializedName("expires_at"       ) var expiresAt      : String?  = null

)