package com.example.controller

import com.example.model.TransactionModel
import com.example.service.TransactionProducer
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Body

@Controller("/transaction")
class TransactionController {

    private final TransactionProducer transactionProducer

    TransactionController(TransactionProducer transactionProducer) {
        this.transactionProducer = transactionProducer
    }

    @Post("/initiateTransfer")
    def initiateTransfer(@Body TransactionModel transactionModel) {
        transactionProducer.sendTransaction(transactionModel)
        println("Transaction sent to Kafka: $transactionModel")
        return  "Transaction Success"
    }
}
