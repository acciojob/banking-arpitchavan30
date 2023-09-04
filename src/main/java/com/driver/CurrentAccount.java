package com.driver;

public class CurrentAccount extends BankAccount {
    private String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000); // minimum balance is 5000 by default

        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }

        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                rearrangeLicenseId();
                return;
            }
        }
    }

    private void rearrangeLicenseId() throws Exception {
        char[] chars = tradeLicenseId.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    if (ch != chars[i - 1] && (i == chars.length - 1 || ch != chars[i + 1])) {
                        chars[i] = ch;
                        break;
                    }
                }
            }
        }

        if (!isValid(chars)) {
            throw new Exception("Valid License cannot be generated");
        }

        tradeLicenseId = new String(chars);
    }

    private boolean isValid(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Getter method
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}