package com.zhigaras.cloudservice.model

class PaymentDto(
    val id: Int,
    val title: String,
    val amount: String? = null,
    val created: Int? = null
)