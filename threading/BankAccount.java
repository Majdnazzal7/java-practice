package threading;


public class BankAccount {

    private int balance;

    // Constructor
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // Deposit money
    public synchronized void deposit(int amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        balance += amount;

    }

    // Withdraw money
    public synchronized boolean withdraw(int amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return false;
        }

        if (balance >= amount) {

            balance -= amount;

            return true;

        } else {

            return false;

        }
    }

    // Get current balance
    public synchronized int getBalance() {

        return balance; 

    }
}
