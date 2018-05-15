package com.dtu.firstreal.service.dto.response;

public class TransactionResponse {
    private String transactionId;

    public TransactionResponse(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
