package BankAccountApp;

import java.util.Random;

public abstract class Account implements IBaseRate {

    private String name;
    private String SIN;
    protected String accountNumber;
    private double balance;
    protected double rate;
    static int uniqueID = 1000;

    public Account(String name, String SIN, double initDeposit) {
        this.name = name;
        this.SIN = SIN;
        this.balance = initDeposit;
        uniqueID++;
        System.out.print("NEW ACCOUNT: ");
        setRate();
    }

    protected String generateAccountNumber() {
        String lastTwoOfSIN = SIN.substring(SIN.length()-2, SIN.length());
        int randomNum = (int)(Math.random() * 1000); // Generate 3 random digits pow(10,3)
        return lastTwoOfSIN + uniqueID + randomNum;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("DEPOSITING $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("WITHDRAWING $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("TRANSFERING $" + amount + " to " + toWhere);
        printBalance();
    }

    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance += accruedInterest;
        System.out.println("ACCRUED INTEREST: $" + accruedInterest);
        printBalance();
    }

    public void printBalance() {
        System.out.println("YOUR BALANCE IS NOW: $" + balance);
    }

    public abstract void setRate();

    void showInfo() {
        System.out.println("NAME: " + name + "\n" +
                "SIN: " + SIN + "\n" +
                "ACCOUNT NUMBER: " + accountNumber + "\n" +
                "BALANCE: " + balance + "\n" +
                "RATE: " + rate + "%");
    }

}
