package service;

import model.Account;
import model.Client;
import repository.BankRepository;
import util.LoggerConfig;

import java.util.UUID;
import java.util.logging.Logger;

public class BankService {
    private static final Logger log = LoggerConfig.LOGGER;
    private final BankRepository repository;

    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    public Client registerClient(String name, String email) {
        Client client = new Client(UUID.randomUUID().toString(), name, email);
        repository.save(client);
        log.info("Registered new client: " + name);
        return client;
    }

    public Account openAccount(Client client, double balance) {
        Account account = new Account(generateAccNumber(), balance);
        client.addAccount(account);
        log.info("Opened account " + account.getAccountNumber() + " for " + client.getName());
        return account;
    }

    private String generateAccNumber() {
        return String.valueOf((long)(Math.random() * 1_000_000_0000L));
    }
}

