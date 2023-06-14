import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private String id;
    private List<BankAccount> accounts;

    public BankCustomer(String name, String id) {
        this.name = name;
        this.id = id;
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "%s accounts: %s".formatted(name, accounts);
    }
}
