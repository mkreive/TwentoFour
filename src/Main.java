
public class Main {
    public static void main(String[] args) {

        BankCustomer john = new BankCustomer("John Snow", "#12344");
        john.addAccount(new BankAccount(Type.CHECKING, 1000.99));
        john.addAccount(new BankAccount(Type.SAVINGS, 455.44));

        System.out.println(john);




    }
}
