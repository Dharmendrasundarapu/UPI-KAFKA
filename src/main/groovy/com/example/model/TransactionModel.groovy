package com.example.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
@Serdeable
class TransactionModel {

    String senderMobileNumber
    String receiverMobileNumber
    BigDecimal amount
    String upiPin

    static constraints = {
        senderMobileNumber nullable: false, blank: false, size: 10..15
        receiverMobileNumber nullable: false, blank: false, size: 10..15
        amount nullable: false, min: 0.01G
        upiPin nullable: false, blank: false, size: 4..6
    }
}
