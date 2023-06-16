import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private final String name;

    private static int lastCustomerId = 10_000_000;
    private final int customerId;
    private final List<BankAccount> accounts = new ArrayList<>();

    BankCustomer(String name, double checkingAmount, double savingAmount) {
        this.name = name;
        customerId = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.Type.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.Type.SAVINGS, savingAmount));
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    public List<BankAccount> getAccounts() {
        return List.copyOf(accounts);
    }

    public BankAccount getAccount(BankAccount.Type type) {
        for (var account: accounts) {
            if(account.getType() == type) {
                return account;
            }
        }
        return null;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        String[] accountString = new String[accounts.size()];
        Arrays.setAll(accountString, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId, String.join("\n\t", accountString));
    }
}
