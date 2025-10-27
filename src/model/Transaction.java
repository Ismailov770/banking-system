package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum Type { DEPOSIT, WITHDRAW, TRANSFER }

    private final String id;
    private final Type type;
    private final String fromAccount;
    private final String toAccount;
    private final double amount;
    private final LocalDateTime timestamp;

    public Transaction(Type type, String fromAccount, String toAccount, double amount) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + type + " from " + fromAccount +
                " to " + toAccount + " amount=" + amount;
    }
}
