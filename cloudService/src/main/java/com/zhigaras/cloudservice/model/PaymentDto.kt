package com.zhigaras.cloudservice.model

class PaymentDto(
    private val id: Int,
    private val title: String,
    private val amount: String? = null,
    private val created: Long? = null
) {
    
    fun toDomain(): PaymentDomain {
        return if (created == null) {
            if (amount == null || amount == "") {
                PaymentDomain.UnknownTimeStampAndAmount(id, title)
            } else {
                PaymentDomain.UnknownTimeStamp(id, title, amount)
            }
        } else {
            if (amount == null || amount == "") {
                PaymentDomain.UnknownAmount(id, title, created)
            } else {
                PaymentDomain.Base(id, title, created, amount)
            }
        }
    }
}