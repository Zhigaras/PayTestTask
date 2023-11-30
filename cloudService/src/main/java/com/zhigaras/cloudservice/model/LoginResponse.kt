package com.zhigaras.cloudservice.model

import com.google.gson.annotations.SerializedName

class LoginResponse(
    @SerializedName("response")
    val token: Token,
    val success: String
)