package bank.accounts;

import bank.loans.LoanEligible;

public class SavingsAccount extends BankAccount implements LoanEligible { // ✅ Implement LoanEligible
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public boolean isEligibleForLoan() { // ✅ Implement loan eligibility logic
        return balance > 50000; // Example: Eligible if balance > 50,000
    }
}



