public class CheckingAccountService implements BankService {
    private CheckingAccount account;

    public CheckingAccountService(CheckingAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public void processWithdrawal(double amount) {
        account.processWithdrawal(amount);
    }

    public void displayAccount() {
        account.displayAccount();
    }
}