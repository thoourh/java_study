import java.util.stream.BaseStream;

public class ClassExample {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
//        bankAccount.password = 123456;
//        System.out.println(bankAccount.password);

        bankAccount.changePassword(123456);
        System.out.println(bankAccount.getPassword());
    }
}
