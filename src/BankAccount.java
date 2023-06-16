import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    enum Type{CHECKING, SAVINGS};
    private final Type type;
    private double balance;
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    public BankAccount(Type type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public Type getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Long, Transaction> getTransactions() {
        return Map.copyOf(transactions);
    }

    @Override
    public String toString() {
        return "%s: %.2f$".formatted(type.toString(), balance);
    }

    void commitTransaction(int routingNUmber, long transactionId, String customerId, double amount) {
        balance += amount;
        transactions.put(transactionId, new Transaction(routingNUmber, transactionId, Integer.parseInt(customerId), amount));
    }
}
