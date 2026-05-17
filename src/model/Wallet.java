package com.wallet.model;

public class Wallet {

    private String walletId;
    private User user;
    private double balance;
    private WalletStatus status;

    public Wallet(String walletId, User user) {
        this.walletId = walletId;
        this.user = user;
        this.balance = 0.0;
        this.status = WalletStatus.ACTIVE;
    }

    public String getWalletId() {
        return walletId;
    }

    public User getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public WalletStatus getStatus() {
        return status;
    }

    public boolean isActive() {
        return status == WalletStatus.ACTIVE;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void blockWallet() {
        this.status = WalletStatus.BLOCKED;
    }

    @Override
    public String toString() {
        return "Wallet ID: " + walletId +
                ", Owner: " + user.getName() +
                ", Balance: ₹" + balance +
                ", Status: " + status;
    }
}