package com.zhigaras.cloudservice.model

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

abstract class PaymentDomain {
    
    protected abstract val id: Int
    protected abstract val title: String
    
    abstract fun isTimeStampKnown(): Boolean
    
    fun areItemsTheSame(other: PaymentDomain) = id == other.id
    
    fun areContentTheSame(other: PaymentDomain) = id == other.id && title == other.title
    
    abstract class CorrectTimeStamp : PaymentDomain() {
        
        abstract val created: Long
        private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm") // TODO: format
        override fun isTimeStampKnown() = true
        
        fun formattedDay(): String = formatter.format(localDateTime())
        
        private fun localDateTime() = LocalDateTime
            .ofEpochSecond(created, 0, OffsetDateTime.now().offset)
        
        fun isNextDay(prevPayment: CorrectTimeStamp?): Boolean {
            if (prevPayment == null) return true
            return localDateTime().truncatedTo(ChronoUnit.DAYS).isAfter(prevPayment.localDateTime())
        }
    }
    
    class Base(
        override val id: Int,
        override val title: String,
        override val created: Long,
        private val amount: String
    ) : CorrectTimeStamp()
    
    class UnknownAmount(
        override val id: Int,
        override val title: String,
        override val created: Long
    ) : CorrectTimeStamp()
    
    abstract class IncorrectTimestamp : PaymentDomain() {
        override fun isTimeStampKnown() = false
    }
    
    class UnknownTimeStamp(
        override val id: Int,
        override val title: String,
        private val amount: String,
    ) : IncorrectTimestamp()
    
    class UnknownTimeStampAndAmount(
        override val id: Int,
        override val title: String,
    ) : IncorrectTimestamp()
}