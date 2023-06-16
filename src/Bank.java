import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final int routingNumber;
    private long lastTransaction;
    private final Map<String, BankCustomer> customers;
    public  Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String id) {
        return customers.get(id);
    }

    public void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
        BankCustomer customer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(customer.getCustomerId(), customer);
    }

    public boolean doTransaction(String id, BankAccount.Type accountType, double amount) {
        BankCustomer customer = customers.get(id);
        if(customer != null) {
            BankAccount account = customer.getAccount(accountType);
            if(account != null) {
                if((account.getBalance() + amount) < 0) {
                    System.out.println("Insufficient funds");
                } else {
                    account.commitTransaction(routingNumber, lastTransaction++, id, amount);
                    return true;
                }
            }
        } else {
            System.out.println("Invalid Customer ID");
        }
        return false;
    }





}
