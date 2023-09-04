package com.driver;

public class SavingsAccount extends BankAccount {
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0); // minimum balance is 0 by default
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }
        super.withdraw(amount);
    }

    public double getSimpleInterest(int years) {
        return getBalance() * (1 + rate * years);
    }

    public double getCompoundInterest(int times, int years) {
        return getBalance() * Math.pow(1 + rate / times, times * years);
    }

    // Getter methods
    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }
}