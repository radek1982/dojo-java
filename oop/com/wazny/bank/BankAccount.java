package com.wazny.bank;


public class BankAccount {
    private static int accountsCreated;
    private static double moneyStored;
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;


    BankAccount() {
        accountsCreated+=1;
        accountNumber = generateAccountNumber();
    }
    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void deposit(double amount, ACCOUNT_TYPE accountType) {

        if (accountType == ACCOUNT_TYPE.CHECKING) {
            checkingBalance += amount;
        }
        else {
            savingsBalance+=amount;
        }
        moneyStored+=amount;

    }

    public static void showStats() {
        System.out.println("------------STATS-------------------");
        System.out.println("Active accounts: " + accountsCreated );
        System.out.println("Total Balance: " + currency(moneyStored) );

    }
    public void showBalances() {
        System.out.printf("%s\nChecking Balance: %s\nSavings Balance %s\n\nTotal Balance: %s\n\n",getAccountNumber(), currency(getCheckingBalance()), currency(getSavingsBalance()),currency(getCheckingBalance() + getSavingsBalance()));
    }

    private static String currency(double amount) {
        return String.format("$%.2f", amount);
    }

    private double processTransaction(double amount, double balance,  ACCOUNT_TYPE accountType) {

        if (balance<amount) {
            throw new InsufficientFundsException(getAccountNumber()+" insufficient funds in " + accountType + " to withdraw " + currency(amount));

        }

        return balance-amount;
    }
    public void withdraw(double amount, ACCOUNT_TYPE accountType) throws  InsufficientFundsException{

        if (accountType == ACCOUNT_TYPE.CHECKING) {

            checkingBalance = processTransaction(amount,checkingBalance,accountType);
        }
        else {
            savingsBalance = processTransaction(amount,savingsBalance,accountType);
        }
    }
    private  String generateAccountNumber() {
        String ts = "" + System.currentTimeMillis();
        return String.format("RWB-%s", ts.substring(5)).substring(0,10);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

 enum ACCOUNT_TYPE {
    CHECKING,
    SAVINGS
}
