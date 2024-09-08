package com.example.service

import com.example.model.TransactionModel
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
interface TransactionProducer {

    @Topic("money-transfer-topic")
    void sendTransaction(TransactionModel transactionModel);
}
