package Classes;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;
    private Transaction[] transactions;
    private int transactionCount;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial Balance must be positive");
        }
        this.accountNumber    = accountNumber;
        this.owner            = owner;
        this.balance          = initialBalance;
        this.transactions     = new Transaction[100];
        this.transactionCount = 0;
        addTransaction("DEPOSIT", initialBalance, initialBalance);

        totalAccounts++;
    }

    public double getBalance() { return balance; }
    public String getOwner() { return owner; }
    public String getAccountNumber() { return accountNumber; }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited amount: " + amount + ". New balance: " + balance);
        addTransaction("DEPOSIT", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.println("Withdraw amount: " + amount + ". New balance: " + balance);
        addTransaction("WITHDRAWAL", amount, balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private void addTransaction(String type, double amount, double balanceAfter) {
        if (transactionCount > 99) {
            System.out.println("Warning: Transaction history full. Cannot record more transactions.");
            return;
        }
        transactions[transactionCount] = new Transaction(type, amount, balanceAfter);
        transactionCount++;
    }

    public void printHistory() {
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{accountNumber = " + accountNumber + ", owner = " + owner + ", balance = " + balance + "}";
    }
}
