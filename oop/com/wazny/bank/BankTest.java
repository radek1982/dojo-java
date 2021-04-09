package com.wazny.bank;

public class BankTest {
    public static void main(String[] args) {
        BankAccount ba;
        ba = new BankAccount();
        ba.deposit(50,ACCOUNT_TYPE.CHECKING);
        ba.deposit(100.35, ACCOUNT_TYPE.SAVINGS);
       // System.out.println(ba.getAccountNumber());
        ba.showBalances();


        BankAccount ba2 = new BankAccount();
        ba2.deposit(20.50, ACCOUNT_TYPE.SAVINGS);


        ba2.showBalances();
        BankAccount.showStats();

        try {
            ba.withdraw(60, ACCOUNT_TYPE.CHECKING);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
