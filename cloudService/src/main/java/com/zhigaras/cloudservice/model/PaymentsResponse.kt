package com.zhigaras.cloudservice.model

import com.google.gson.annotations.SerializedName

class PaymentsResponse(
    @SerializedName("response")
    val payments: List<PaymentDto>,
    val success: String
)