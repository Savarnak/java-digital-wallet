package com.wallet.main;

import com.wallet.service.WalletService;

import java.util.Scanner;

public class WalletApplication {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "1234";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WalletService walletService = new WalletService();

        while (true) {
            System.out.println("\n===== Digital Wallet System =====");
            System.out.println("1. Create Wallet");
            System.out.println("2. Add Money");
            System.out.println("3. Send Money");
            System.out.println("4. View Balance");
            System.out.println("5. View Transactions");
            System.out.println("6. Block Wallet");
            System.out.println("7. View All Wallets (Admin Only)");
            System.out.println("8. View Total Money in System (Admin Only)");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    walletService.createWallet(name, phone);
                    break;

                case 2:
                    System.out.print("Enter Wallet ID: ");
                    String walletIdAdd = scanner.nextLine();

                    System.out.print("Enter Amount: ");
                    double amountAdd = Double.parseDouble(scanner.nextLine());

                    walletService.addMoney(walletIdAdd, amountAdd);
                    break;

                case 3:
                    System.out.print("Enter Sender Wallet ID: ");
                    String fromId = scanner.nextLine();

                    System.out.print("Enter Receiver Wallet ID: ");
                    String toId = scanner.nextLine();

                    System.out.print("Enter Amount: ");
                    double transferAmount = Double.parseDouble(scanner.nextLine());

                    walletService.sendMoney(fromId, toId, transferAmount);
                    break;

                case 4:
                    System.out.print("Enter Wallet ID: ");
                    String walletIdView = scanner.nextLine();

                    walletService.viewBalance(walletIdView);
                    break;

                case 5:
                    System.out.print("Enter Wallet ID: ");
                    String walletIdTxn = scanner.nextLine();

                    walletService.viewTransactions(walletIdTxn);
                    break;

                case 6:
                    System.out.print("Enter Wallet ID to block: ");
                    String walletIdBlock = scanner.nextLine();

                    walletService.blockWallet(walletIdBlock);
                    break;

                case 7:
                    if (authenticateAdmin(scanner)) {
                        walletService.viewAllWallets();
                    }
                    break;

                case 8:
                    if (authenticateAdmin(scanner)) {
                        walletService.viewTotalMoneyInSystem();
                    }
                    break;

                case 9:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private static boolean authenticateAdmin(Scanner scanner) {

        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("Admin authentication successful.");
            return true;
        } else {
            System.out.println("Invalid admin credentials!");
            return false;
        }
    }
}