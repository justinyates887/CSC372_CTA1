public class CheckingAccount extends BankAccount {
    private double interestRate;

    public CheckingAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    public void processWithdrawal(double amount) {
        if (getBalance() < amount) {
            withdrawal(amount + 30);
            System.out.println("Overdraft! A $30 fee has been applied.");
        } else {
            withdrawal(amount);
        }
    }

    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate);
    }
}