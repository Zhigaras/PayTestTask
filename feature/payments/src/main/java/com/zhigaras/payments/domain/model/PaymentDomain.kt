package com.zhigaras.payments.domain.model

import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.zhigaras.cloudservice.model.PaymentDto
import com.zhigaras.core.ManageResources
import com.zhigaras.core.formatPrice
import com.zhigaras.payments.R
import com.zhigaras.payments.databinding.BasePaymentItemBinding
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class PaymentDomain(
    private val id: Int,
    private val title: String,
    val amount: Amount,
    private val created: Created
) {
    
    fun bind(binding: BasePaymentItemBinding) = with(binding) {
        titleTextview.text = title
        amount.bind(amountTextview)
    }
    
    fun areItemsTheSame(other: PaymentDomain) = id == other.id
    
    fun formattedDay(resources: ManageResources) = created.formattedDay(resources)
    
    companion object {
        fun fromDto(dto: PaymentDto): PaymentDomain {
            val created = if (dto.created == null) Created.Empty() else Created.Base(dto.created!!)
            val amount =
                if (dto.amount == null || dto.amount == "") Amount.Empty()
                else Amount.Base(dto.amount!!.toDouble())
            return PaymentDomain(dto.id, dto.title, amount, created)
        }
    }
}

interface Created {
    
    fun formattedDay(resources: ManageResources): String
    
    class Base(timeStamp: Int) : Created {
        
        private val formatter = DateTimeFormatter.ofPattern("dd MMM, EE")
        private val localDateTime = LocalDateTime
            .ofEpochSecond(timeStamp.toLong(), 0, OffsetDateTime.now().offset)
        
        override fun formattedDay(resources: ManageResources): String =
            formatter.format(localDateTime)
    }
    
    class Empty : Created {
        override fun formattedDay(resources: ManageResources) =
            resources.getString(R.string.date_stub)
        
    }
}

interface Amount {
    
    fun amount(): Double
    
    fun bind(textView: TextView)
    
    class Base(private val amount: Double) : Amount {
        override fun amount() = amount
        
        override fun bind(textView: TextView) = with(textView) {
            text = context.getString(R.string.payment_amount, amount.formatPrice())
            setTextColor(ResourcesCompat.getColor(resources, R.color.red10, null))
        }
    }
    
    class Empty : Amount {
        override fun amount() = 0.0
        
        override fun bind(textView: TextView) = with(textView) {
            text = context.getText(R.string.amount_stub)
        }
    }
}
