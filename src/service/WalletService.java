package com.wallet.service;

import com.wallet.model.*;

import java.util.*;

public class WalletService {

    private Map<String, Wallet> walletMap = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private Set<String> registeredPhones = new HashSet<>();

    // -------------------------------
    // STEP 1: Mobile Validation Method
    // -------------------------------
    private boolean isValidMobile(String phoneNumber) {
        return phoneNumber.matches("^[6-9]\\d{9}$");
    }

    // -------------------------------
    // STEP 2: Create Wallet (Updated)
    // -------------------------------
    public Wallet createWallet(String name, String phoneNumber) {

        if (!isValidMobile(phoneNumber)) {
            System.out.println("Invalid mobile number! Must be 10 digits and start with 6-9.");
            return null;
        }

        if (registeredPhones.contains(phoneNumber)) {
            System.out.println("Phone number already registered!");
            return null;
        }

        String userId = UUID.randomUUID().toString();
        String walletId = UUID.randomUUID().toString();

        User user = new User(userId, name, phoneNumber);
        Wallet wallet = new Wallet(walletId, user);

        walletMap.put(walletId, wallet);
        registeredPhones.add(phoneNumber);

        System.out.println("Wallet created successfully!");
        System.out.println("Wallet ID: " + walletId);

        return wallet;
    }

    // Add Money
    public void addMoney(String walletId, double amount) {

        Wallet wallet = walletMap.get(walletId);

        if (wallet == null) {
            System.out.println("Wallet not found!");
            return;
        }

        if (!wallet.isActive()) {
            System.out.println("Wallet is blocked!");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        wallet.setBalance(wallet.getBalance() + amount);

        Transaction transaction = new Transaction(
                walletId,
                walletId,
                TransactionType.ADD_MONEY,
                amount
        );

        transactions.add(transaction);

        System.out.println("Money added successfully!");
        System.out.println("Updated Balance: ₹" + wallet.getBalance());
    }

    // Send Money
    public void sendMoney(String fromWalletId, String toWalletId, double amount) {

        Wallet sender = walletMap.get(fromWalletId);
        Wallet receiver = walletMap.get(toWalletId);

        if (sender == null) {
            System.out.println("Sender wallet not found!");
            return;
        }

        if (receiver == null) {
            System.out.println("Receiver wallet not found!");
            return;
        }

        if (!sender.isActive() || !receiver.isActive()) {
            System.out.println("One of the wallets is blocked!");
            return;
        }

        if (fromWalletId.equals(toWalletId)) {
            System.out.println("Cannot transfer to same wallet!");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        Transaction transaction = new Transaction(
                fromWalletId,
                toWalletId,
                TransactionType.SEND_MONEY,
                amount
        );

        transactions.add(transaction);

        System.out.println("Transfer successful!");
        System.out.println("Sender Balance: ₹" + sender.getBalance());
    }

    // View Balance
    public void viewBalance(String walletId) {

        Wallet wallet = walletMap.get(walletId);

        if (wallet == null) {
            System.out.println("Wallet not found!");
            return;
        }

        System.out.println("Current Balance: ₹" + wallet.getBalance());
    }

    // View Transactions
    public void viewTransactions(String walletId) {

        boolean found = false;

        for (Transaction transaction : transactions) {
            if (transaction.getFromWalletId().equals(walletId) ||
                    transaction.getToWalletId().equals(walletId)) {

                System.out.println(transaction);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found!");
        }
    }

    // Block Wallet
    public void blockWallet(String walletId) {

        Wallet wallet = walletMap.get(walletId);

        if (wallet == null) {
            System.out.println("Wallet not found!");
            return;
        }

        wallet.blockWallet();
        System.out.println("Wallet blocked successfully!");
    }

    // View All Wallets (Admin)
    public void viewAllWallets() {

        if (walletMap.isEmpty()) {
            System.out.println("No wallets found!");
            return;
        }

        for (Wallet wallet : walletMap.values()) {
            System.out.println(wallet);
        }
    }

    // Total Money in System
    public void viewTotalMoneyInSystem() {

        double total = 0;

        for (Wallet wallet : walletMap.values()) {
            total += wallet.getBalance();
        }

        System.out.println("Total Money in Wallet System: ₹" + total);
    }
}