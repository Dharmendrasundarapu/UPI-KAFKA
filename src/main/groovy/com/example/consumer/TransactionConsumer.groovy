package com.example.consumer

import com.example.model.TransactionModel
import com.example.service.GormTransactionClient
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import jakarta.inject.Inject;
import io.micronaut.http.HttpResponse;

@KafkaListener
public class TransactionConsumer {

    @Inject
    GormTransactionClient gormTransactionClient;

    @Topic("money-transfer-topic")
    public void receive(TransactionModel transactionModel) {
        // Call the GORM microservice and get the response
        HttpResponse<String> response = gormTransactionClient.transferMoney(transactionModel);

        // Log the full response from GORM microservice
        System.out.println("GORM Microservice Response: " + response.getBody().orElse("No response body"));
        System.out.println("Status Code: " + response.getStatus());
    }
}
