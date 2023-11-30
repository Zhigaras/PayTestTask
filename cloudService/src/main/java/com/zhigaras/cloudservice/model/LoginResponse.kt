package com.zhigaras.cloudservice.model

import com.google.gson.annotations.SerializedName

class LoginResponse(
    val success: String,
    @SerializedName("response")
    val token: Token? = null,
    val error: LoginError? = null
)