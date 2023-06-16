public class Banking {
    public static void main(String[] args) {

        Bank bank = new Bank(3214567);
        bank.addCustomer("John", 500.00, 10000.00);

        BankCustomer john = bank.getCustomer("000000010000000");
        System.out.println(john);


    }
}
