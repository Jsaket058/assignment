// Encapsulation Example: Bank Account
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String geAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

public class OOP3{
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Saket Jain", 1000);
        
        System.out.println("Account Holder name: "+ account.geAccountHolder());

        System.out.println("Current Balance: " + account.getBalance());

        account.deposit(500);
        System.out.println("Updated Balance: " + account.getBalance());

        account.withdraw(300);
        System.out.println("Final Balance: " + account.getBalance());
    }
}
