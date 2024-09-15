public class Test {

    public static void main(String[] args) {
        testDeposit();
        testProcessWithdrawalWithinBalance();
        testProcessWithdrawalWithOverdraft();
        testAccountSummary();
        System.out.println("All tests completed.");
    }

    public static void testDeposit() {
    	//arrange
        CheckingAccount account = new CheckingAccount(0.02);
        CheckingAccountService service = new CheckingAccountService(account);
        //act
        service.deposit(500);
        
        //assert
        if (account.getBalance() == 500) {
            System.out.println("testDeposit passed.");
        } else {
            System.out.println("testDeposit failed.");
        }
    }

    public static void testProcessWithdrawalWithinBalance() {
        CheckingAccount account = new CheckingAccount(0.02);
        CheckingAccountService service = new CheckingAccountService(account);
        service.deposit(500);
        service.processWithdrawal(200);
        
        if (account.getBalance() == 300) {
            System.out.println("testProcessWithdrawalWithinBalance passed.");
        } else {
            System.out.println("testProcessWithdrawalWithinBalance failed.");
        }
    }

    public static void testProcessWithdrawalWithOverdraft() {
        CheckingAccount account = new CheckingAccount(0.02);
        CheckingAccountService service = new CheckingAccountService(account);
        service.deposit(200);
        service.processWithdrawal(250);
        
        if (account.getBalance() == -80) {
            System.out.println("testProcessWithdrawalWithOverdraft passed.");
        } else {
            System.out.println("testProcessWithdrawalWithOverdraft failed.");
        }
    }

    public static void testAccountSummary() {
        CheckingAccount account = new CheckingAccount(0.02);
        CheckingAccountService service = new CheckingAccountService(account);
        account.setFirstName("John");
        account.setLastName("Doe");
        account.setAccountID(12345);
        service.deposit(500);

        if ("John".equals(account.getFirstName()) &&
            "Doe".equals(account.getLastName()) &&
            account.getAccountID() == 12345 &&
            account.getBalance() == 500) {
            System.out.println("testAccountSummary passed.");
        } else {
            System.out.println("testAccountSummary failed.");
        }
    }
}
