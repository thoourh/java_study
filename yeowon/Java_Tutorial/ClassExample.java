public class ClassExample{

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();

        /* System.out.println(bankAccount);
        System.out.println(bankAccount.bankCode);
        System.out.println(bankAccount.isDormant);
        bankAccount.password = 123456;*/

        bankAccount.changePassword(123456);
        System.out.println(bankAccount.getPassword());
        //System.out.println(bankAccount.password);

    }
}
