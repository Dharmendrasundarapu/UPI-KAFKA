package com.example.service

import com.example.model.TransactionModel
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.annotation.Client;

@Client("http://localhost:9090")  // Make sure this is the correct address for the GORM service
public interface GormTransactionClient {

    @Post("/transaction/transfer")
    HttpResponse<String> transferMoney(@Body TransactionModel transactionModel);
}
