package threads;
import model.Account;
import service.TransactionService;

public class TransactionThread extends Thread {
    private final TransactionService service;
    private final Account from;
    private final Account to;
    private final double amount;

    public TransactionThread(TransactionService service, Account from, Account to, double amount) {
        this.service = service;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            service.transfer(from, to, amount);
        } catch (Exception e) {
            System.err.println("Error in thread: " + e.getMessage());
        }
    }
}
