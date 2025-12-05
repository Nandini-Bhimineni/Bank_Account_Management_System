package bank.accounts;

import bank.loans.LoanEligible;

public class CheckingAccount extends BankAccount implements LoanEligible { // ✅ Implement LoanEligible
    public CheckingAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public boolean isEligibleForLoan() { // ✅ Implement loan eligibility logic
        return balance > 100000; // Example: Eligible if balance > 100,000
    }
}





