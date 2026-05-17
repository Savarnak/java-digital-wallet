package com.wallet.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    private String transactionId;
    private String fromWalletId;
    private String toWalletId;
    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String fromWalletId, String toWalletId,
                       TransactionType type, double amount) {

        this.transactionId = UUID.randomUUID().toString();
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFromWalletId() {
        return fromWalletId;
    }

    public String getToWalletId() {
        return toWalletId;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                ", Type: " + type +
                ", Amount: ₹" + amount +
                ", Time: " + timestamp;
    }
}
