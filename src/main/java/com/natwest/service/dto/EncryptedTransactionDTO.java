package com.natwest.service.dto;

public class EncryptedTransactionDTO {

    private TransactionDTO body;

    public TransactionDTO getBody() {
        return body;
    }

    public void setBody(TransactionDTO body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EncryptedTransactionDTO [body=" + body + "]";
    }
}
