package com.driver;

public class StudentAccount extends BankAccount {
    private String institutionName;

    public StudentAccount(String name, double balance, String institutionName) {
        super(name, balance, 0); // minimum balance is 0 by default
        this.institutionName = institutionName;
    }

    // Getter method
    public String getInstitutionName() {
        return institutionName;
    }
}