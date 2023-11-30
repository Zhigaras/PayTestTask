package com.zhigaras.cloudservice.model


import com.google.gson.annotations.SerializedName

data class PaymentsResponse(
    @SerializedName("response")
    val payments: List<Payment>,
    val success: String
)