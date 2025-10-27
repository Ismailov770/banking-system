package controller;

import model.Account;
import model.Client;
import repository.BankRepository;
import service.BankService;
import service.TransactionService;

public class BankController {
    private final BankService bankService;
    private final TransactionService transactionService;

    public BankController(BankRepository repository) {
        this.bankService = new BankService(repository);
        this.transactionService = new TransactionService();
    }

    public void simulate() throws Exception {
        Client alice = bankService.registerClient("Alice", "alice@mail.com");
        Client bob = bankService.registerClient("Bob", "bob@mail.com");

        Account acc1 = bankService.openAccount(alice, 1000);
        Account acc2 = bankService.openAccount(bob, 500);

        transactionService.transfer(acc1, acc2, 200);
        transactionService.deposit(acc2, 300);

        System.out.println(alice);
        System.out.println(bob);
    }
}

