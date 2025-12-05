package bank;

import bank.accounts.*;
import bank.loans.LoanEligible;
import bank.utils.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ✅ Step 1: Store customer details using an ARRAY
        System.out.print("Enter number of accounts: ");
        int numAccounts = scanner.nextInt();
        scanner.nextLine();

        BankAccount[] accountArray = new BankAccount[numAccounts]; // Using array first

        for (int i = 0; i < numAccounts; i++) {
            System.out.println("\n--- Creating Account " + (i + 1) + " ---");
            System.out.print("Enter Account Number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Enter Account Holder Name: ");
            String accountHolder = scanner.nextLine();

            System.out.print("Enter Initial Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Account Type (1 for Savings, 2 for Checking): ");
            int type = scanner.nextInt();
            scanner.nextLine();

            if (type == 1) {
                accountArray[i] = new SavingsAccount(accountNumber, accountHolder, balance);
            } else {
                accountArray[i] = new CheckingAccount(accountNumber, accountHolder, balance);
            }

            // ✅ Display account after creation
            System.out.println("\n--- Account Created Successfully ---");
            accountArray[i].displayAccount();
            System.out.println("------------------------------------");
        }

        // ✅ Step 2: Transfer accounts to an ArrayList
        List<BankAccount> accounts = new ArrayList<>();
        Vector<BankAccount> inactiveAccounts = new Vector<>();

        for (BankAccount acc : accountArray) {
            if (acc.getBalance() <= 0) {
                inactiveAccounts.add(acc); // ✅ Store inactive accounts in Vector
            } else {
                accounts.add(acc); // ✅ Store active accounts in ArrayList
            }
        }

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Active Accounts");
            System.out.println("4. Display Inactive Accounts");
            System.out.println("5. Search Account by Number");
            System.out.println("6. Search Account by Name (Partial Match)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = scanner.nextLine();
                    BankAccount acc = findAccount(accounts, accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double amount = scanner.nextDouble();
                        acc.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    String accNo = scanner.nextLine();
                    BankAccount acc = findAccount(accounts, accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double amount = scanner.nextDouble();
                        try {
                            acc.withdraw(amount);
                            if (acc.getBalance() <= 0) {
                                accounts.remove(acc);
                                inactiveAccounts.add(acc);
                                System.out.println("Account moved to inactive accounts due to zero/negative balance.");
                            }
                        } catch (InsufficientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                }
                case 3 -> {
                    System.out.println("\nActive Accounts:");
                    Collections.sort(accounts); // ✅ Sort accounts by name

                    for (BankAccount acc : accounts) {
                        acc.displayAccount();

                        if (acc instanceof LoanEligible loanAcc) { // ✅ Check Loan Eligibility
                            System.out.println("Loan Eligibility: " + (loanAcc.isEligibleForLoan() ? "Eligible ✅" : "Not Eligible ❌"));
                        }
                        System.out.println("-----------------");
                    }
                }




                case 4 -> {
                    System.out.println("\nInactive Accounts:");
                    for (BankAccount acc : inactiveAccounts) {
                        acc.displayAccount();
                        System.out.println("-----------------");
                    }
                }
                case 5 -> {
                    System.out.print("Enter Account Number to Search: ");
                    String accNo = scanner.nextLine();
                    BankAccount acc = findAccount(accounts, accNo);
                    if (acc != null) {
                        acc.displayAccount();
                        if (acc instanceof LoanEligible) {
                            System.out.println("Loan Eligibility: " + (((LoanEligible) acc).isEligibleForLoan() ? "Eligible ✅" : "Not Eligible ❌"));
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                }
                case 6 -> {
                    System.out.print("Enter Partial Name to Search: ");
                    String partialName = scanner.nextLine();
                    searchByName(accounts, partialName);
                }
                case 7 -> {
                    System.out.println("Exiting the system...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ✅ Search by Account Number
    private static BankAccount findAccount(List<BankAccount> accounts, String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }
        return null;
    }

    // ✅ Partial Search by Name (Case-Insensitive)
    private static void searchByName(List<BankAccount> accounts, String partialName) {
        boolean found = false;
        for (BankAccount acc : accounts) {
            if (acc.getAccountHolder().toLowerCase().contains(partialName.toLowerCase())) {
                acc.displayAccount();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No accounts matched the search.");
        }
    }
}




