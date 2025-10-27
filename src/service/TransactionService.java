package service;


import exceptions.InsufficientFundsException;
import model.Account;
import util.LoggerConfig;

import java.util.logging.Logger;

public class TransactionService {
    private static final Logger log = LoggerConfig.LOGGER;

    public void transfer(Account from, Account to, double amount)
            throws InsufficientFundsException {

        Account first = from.getAccountNumber().compareTo(to.getAccountNumber()) < 0 ? from : to;
        Account second = first == from ? to : from;

        first.getLock().lock();
        second.getLock().lock();
        try {
            if (from.getBalance() < amount)
                throw new InsufficientFundsException("Not enough balance!");
            from.withdraw(amount);
            to.deposit(amount);
            log.info("Transferred " + amount + " from " + from.getAccountNumber() + " to " + to.getAccountNumber());
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }

    public void deposit(Account account, double amount) {
        account.getLock().lock();
        try {
            account.deposit(amount);
            log.info("Deposited " + amount + " to " + account.getAccountNumber());
        } finally {
            account.getLock().unlock();
        }
    }
}
