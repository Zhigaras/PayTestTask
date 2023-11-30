package com.zhigaras.cloudservice.model

import com.google.gson.annotations.SerializedName

class LoginError(
    @SerializedName("error_code")
    val errorCode: Int,
    @SerializedName("error_msg")
    val errorMsg: String
)