package bank.accounts;

import bank.utils.InsufficientBalanceException;

public abstract class BankAccount implements Comparable<BankAccount> { // ✅ Implement Comparable
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient funds!");
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void displayAccount() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    @Override
    public int compareTo(BankAccount other) { // ✅ Define sorting order (by name)
        return this.accountHolder.compareToIgnoreCase(other.accountHolder);
    }
}



