package com.zhigaras.cloudservice.model

data class Payment(
    val amount: Double,
    val created: Int,
    val id: Int,
    val title: String
)