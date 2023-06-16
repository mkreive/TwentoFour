public class Transaction {
    private int routingNumber;
    private long transactionId;
    private int customerId;
    private double amount;

    public Transaction(int routingNUmber, long transactionId, int customerId, double amount) {
        this.routingNumber = routingNUmber;
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "%015d:%020d:%015d:%012.2f".formatted(routingNumber, customerId, transactionId, amount);
    }
}
