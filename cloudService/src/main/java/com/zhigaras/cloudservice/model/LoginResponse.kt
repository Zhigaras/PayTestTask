package com.zhigaras.cloudservice.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("response")
    val token: Token,
    val success: String
)