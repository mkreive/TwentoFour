enum Type{CHECKING, SAVINGS};

public class BankAccount {
    private Type type;
    private double balance;

    public BankAccount(Type type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "%s account, balance = %.2f$".formatted(type.toString(), balance);
    }
}
