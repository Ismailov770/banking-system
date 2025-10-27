package model;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String accountNumber;
    private double balance;
    private transient ReentrantLock lock = new ReentrantLock();

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }

    public ReentrantLock getLock() {
        if (lock == null) lock = new ReentrantLock();
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" + accountNumber + ", balance=" + balance + '}';
    }
}
