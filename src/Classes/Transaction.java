package Classes;

public class Transaction {
    private String type;
    private double amount;
    private double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        if (!type.equals("DEPOSIT") && !type.equals("WITHDRAWAL")) {
            throw new IllegalArgumentException("Type must be either 'DEPOSIT' or 'WITHDRAWAL'");
        }
        this.type         = type;
        this.amount       = amount;
        this.balanceAfter = balanceAfter;
    }

    public String getType() { return type; }
    public double getAmount() { return amount; }
    public double getBalanceAfter() { return balanceAfter; }

    @Override
    public String toString() {
        return "Transaction{type = " + getType() + ", amount = "
                    + getAmount() + ", balanceAfter = " + getBalanceAfter() + "}";
    }
}
