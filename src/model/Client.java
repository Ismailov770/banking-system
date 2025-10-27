package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String id;
    private final String name;
    private final String email;
    private final List<Account> accounts = new ArrayList<>();

    public Client(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Account> getAccounts() { return accounts; }

    public void addAccount(Account account) { accounts.add(account); }

    @Override
    public String toString() {
        return "Client{" + id + ", " + name + ", accounts=" + accounts + '}';
    }
}