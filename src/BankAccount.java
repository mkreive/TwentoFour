
public class BankAccount {
    enum Type{CHECKING, SAVINGS};
    private final Type type;
    private final double balance;

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

    @Override
    public String toString() {
        return "%s: %.2f$".formatted(type.toString(), balance);
    }
}
