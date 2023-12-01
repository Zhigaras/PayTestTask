package com.zhigaras.payments.domain.model

import androidx.core.content.res.ResourcesCompat
import com.zhigaras.cloudservice.model.PaymentDto
import com.zhigaras.core.formatPrice
import com.zhigaras.payments.R
import com.zhigaras.payments.databinding.BasePaymentItemBinding
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

abstract class PaymentDomain {
    
    protected abstract val id: Int
    protected abstract val title: String
    
    abstract fun isTimeStampKnown(): Boolean
    abstract fun bind(binding: BasePaymentItemBinding)
    
    fun areItemsTheSame(other: PaymentDomain) = id == other.id
    
    fun areContentTheSame(other: PaymentDomain) = id == other.id && title == other.title
    
    abstract class CorrectTimeStamp : PaymentDomain() {
        
        abstract val created: Long
        private val formatter = DateTimeFormatter.ofPattern("dd MMM, EE")
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
        private val amount: Double
    ) : CorrectTimeStamp() {
        override fun bind(binding: BasePaymentItemBinding): Unit = with(binding) {
            titleTextview.text = title
            amountTextview.apply {
                text = root.context.getString(R.string.payment_amount, amount.formatPrice())
                setTextColor(ResourcesCompat.getColor(root.resources, R.color.red10, null))
            }
        }
    }
    
    class UnknownAmount(
        override val id: Int,
        override val title: String,
        override val created: Long
    ) : CorrectTimeStamp() {
        override fun bind(binding: BasePaymentItemBinding) = with(binding) {
            titleTextview.text = title
            amountTextview.text = root.context.getText(R.string.amount_stub)
        }
    }
    
    abstract class IncorrectTimestamp : PaymentDomain() {
        override fun isTimeStampKnown() = false
    }
    
    class UnknownTimeStamp(
        override val id: Int,
        override val title: String,
        private val amount: Double,
    ) : IncorrectTimestamp() {
        override fun bind(binding: BasePaymentItemBinding): Unit = with(binding) {
            titleTextview.text = title
            amountTextview.apply {
                text = root.context.getString(R.string.payment_amount, amount.formatPrice())
                setTextColor(ResourcesCompat.getColor(root.resources, R.color.red10, null))
            }
        }
    }
    
    class UnknownTimeStampAndAmount(
        override val id: Int,
        override val title: String,
    ) : IncorrectTimestamp() {
        override fun bind(binding: BasePaymentItemBinding) = with(binding) {
            titleTextview.text = title
            amountTextview.text = root.context.getText(R.string.amount_stub)
        }
    }
    
    companion object {
        fun fromDto(dto: PaymentDto): PaymentDomain {
            return if (dto.created == null) {
                if (dto.amount == null || dto.amount == "") {
                    UnknownTimeStampAndAmount(dto.id, dto.title)
                } else {
                    UnknownTimeStamp(dto.id, dto.title, dto.amount!!.toDouble())
                }
            } else {
                if (dto.amount == null || dto.amount == "") {
                    UnknownAmount(dto.id, dto.title, dto.created!!)
                } else {
                    Base(dto.id, dto.title, dto.created!!, dto.amount!!.toDouble())
                }
            }
        }
    }
}